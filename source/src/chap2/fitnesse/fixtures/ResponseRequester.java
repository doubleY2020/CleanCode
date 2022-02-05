// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fit.ColumnFixture;
import chap2.fitnesse.http.*;
import chap2.fitnesse.wiki.*;
import chap2.fitnesse.*;
import chap2.fitnesse.wikitext.Utils;
import chap2.fitnesse.testutil.MockSocket;

public class ResponseRequester extends ColumnFixture
{
	public String uri;
	public String username;
	public String password;

	protected MockRequest request;

	public boolean valid() throws Exception
	{
		return status() == 200;
	}

	public void execute() throws Exception
	{
		request = new MockRequest();

		details();

		if(username != null)
			request.setCredentials(username, password);

		request.parseRequestUri("/" + uri);
		FitnesseFixtureContext.page = FitnesseFixtureContext.root.getPageCrawler().getPage(FitnesseFixtureContext.root, PathParser.parse(uri));
		FitNesseExpediter expediter = new FitNesseExpediter(new MockSocket(""), FitnesseFixtureContext.context);
		FitnesseFixtureContext.response = expediter.createGoodResponse(request);
		FitnesseFixtureContext.sender = new MockResponseSender(FitnesseFixtureContext.response);
	}
             
	public int status() throws Exception
	{
		int status = FitnesseFixtureContext.response.getStatus();
		return status;
	}

	public String contents() throws Exception
	{
		return "<pre>" + Utils.escapeText(FitnesseFixtureContext.sender.sentData()) + "</pre>";
	}

	protected void details()
	{
	}
}
