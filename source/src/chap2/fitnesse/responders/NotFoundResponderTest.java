// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders;

import chap2.fitnesse.*;
import chap2.fitnesse.wiki.*;
import chap2.fitnesse.testutil.RegexTest;
import chap2.fitnesse.http.*;
import junit.swingui.TestRunner;

public class NotFoundResponderTest extends RegexTest
{
	public static void main(String[] args)
	{
		TestRunner.main(new String[]{"NotFoundResponderTest"});
	}

	public void setUp() throws Exception
	{
	}

	public void tearDown() throws Exception
	{
	}

	public void testResponse() throws Exception
	{
		MockRequest request = new MockRequest();
		request.setResource("some page");

		Responder responder = new NotFoundResponder();
		SimpleResponse response = (SimpleResponse)responder.makeResponse(new FitNesseContext(), request);

		assertEquals(404, response.getStatus());

		String body = response.getContent();

		assertHasRegexp("<html>", body);
		assertHasRegexp("<body", body);
		assertHasRegexp("some page", body);
		assertHasRegexp("Not Found", body);
	}

	public void testHasEditLinkForWikiWords() throws Exception
	{
		MockRequest request = new MockRequest();
		request.setResource("PageOne.PageTwo");
		WikiPage root = InMemoryPage.makeRoot("RooT");

		Responder responder = new NotFoundResponder();
		SimpleResponse response = (SimpleResponse)responder.makeResponse(new FitNesseContext(root), request);

		assertHasRegexp("href=\"PageOne[.]PageTwo[?]edit\"", response.getContent());
	}

}
