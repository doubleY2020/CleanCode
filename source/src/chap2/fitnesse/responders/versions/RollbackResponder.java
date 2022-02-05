// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.versions;

import chap2.fitnesse.*;
import chap2.fitnesse.responders.*;
import chap2.fitnesse.authentication.*;
import chap2.fitnesse.components.*;
import chap2.fitnesse.wiki.*;
import chap2.fitnesse.http.*;

public class RollbackResponder implements SecureResponder
{
	public Response makeResponse(FitNesseContext context, Request request) throws Exception
	{
		SimpleResponse response = new SimpleResponse();

		String resource = request.getResource();
		String version = (String) request.getInput("version");

		WikiPagePath path = PathParser.parse(resource);
		WikiPage page = context.root.getPageCrawler().getPage(context.root, path);
		if(page == null)
			return new NotFoundResponder().makeResponse(context, request);
		PageData data = page.getDataVersion(version);

		page.commit(data);

		RecentChanges.updateRecentChanges(data);
		response.redirect(resource);

		return response;
	}

	public SecureOperation getSecureOperation()
	{
		return new SecureWriteOperation();
	}
}
