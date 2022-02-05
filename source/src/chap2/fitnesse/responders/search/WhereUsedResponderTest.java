// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.search;

import chap2.fitnesse.wiki.*;
import chap2.fitnesse.http.*;
import chap2.fitnesse.testutil.RegexTest;
import chap2.fitnesse.FitNesseContext;

public class WhereUsedResponderTest extends RegexTest
{
	private WikiPage root;
	private WikiPage pageTwo;

	public void setUp() throws Exception
	{
		root = InMemoryPage.makeRoot("RooT");
		PageCrawler crawler = root.getPageCrawler();
		crawler.addPage(root, PathParser.parse("PageOne"), "PageOne");
		pageTwo = crawler.addPage(root, PathParser.parse("PageTwo"), "PageOne");
		crawler.addPage(pageTwo, PathParser.parse("ChildPage"), ".PageOne");
	}

	public void testResponse() throws Exception
	{
		MockRequest request = new MockRequest();
		request.setResource("PageOne");
		WhereUsedResponder responder = new WhereUsedResponder();

		Response response = responder.makeResponse(new FitNesseContext(root), request);
		MockResponseSender sender = new MockResponseSender();
		response.readyToSend(sender);
		sender.waitForClose(5000);
		
		String content = sender.sentData();
		assertEquals(200, response.getStatus());
		assertHasRegexp("Where Used", content);
		assertHasRegexp(">PageOne<", content);
		assertHasRegexp(">PageTwo<", content);
		assertHasRegexp(">PageTwo\\.ChildPage<", content);
	}
}

