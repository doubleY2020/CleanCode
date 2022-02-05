// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.editing;

import chap2.fitnesse.wiki.*;
import chap2.fitnesse.http.*;
import chap2.fitnesse.*;
import chap2.fitnesse.testutil.RegexTest;

public class MergeResponderTest extends RegexTest
{
	private WikiPage source;
	private MockRequest request;

	public void setUp() throws Exception
	{
		source = InMemoryPage.makeRoot("RooT");
		source.getPageCrawler().addPage(source, PathParser.parse("SimplePage"), "this is SimplePage");
		request = new MockRequest();
		request.setResource("SimplePage");
		request.addInput(EditResponder.SAVE_ID, "");
		request.addInput(EditResponder.CONTENT_INPUT_NAME, "some new content");
	}

	public void tearDown() throws Exception
	{
	}

	public void testHtml() throws Exception
	{
		Responder responder = new MergeResponder(request);
		SimpleResponse response = (SimpleResponse)responder.makeResponse(new FitNesseContext(source), new MockRequest());
		assertHasRegexp("name=\\\"" + EditResponder.CONTENT_INPUT_NAME + "\\\"", response.getContent());
		assertHasRegexp("this is SimplePage", response.getContent());
		assertHasRegexp("name=\\\"oldContent\\\"", response.getContent());
		assertHasRegexp("some new content", response.getContent());
	}

	public void testAttributeValues() throws Exception
	{
		request.addInput("Edit", "On");
		request.addInput("Test", "On");
		request.addInput("Search", "On");
		Responder responder = new MergeResponder(request);
		SimpleResponse response = (SimpleResponse)responder.makeResponse(new FitNesseContext(source), new MockRequest());

		assertHasRegexp("type=\"hidden\"", response.getContent());
		assertHasRegexp("name=\"Edit\"", response.getContent());
		assertHasRegexp("name=\"Test\"", response.getContent());
		assertHasRegexp("name=\"Search\"", response.getContent());
	}
}