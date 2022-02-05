// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.files;

import chap2.fitnesse.*;
import chap2.fitnesse.testutil.RegexTest;
import chap2.fitnesse.http.*;

public class DeleteConfirmationResponderTest extends RegexTest
{
	MockRequest request;
	private FitNesseContext context;

	public void setUp() throws Exception
	{
		request = new MockRequest();
		context = new FitNesseContext();
	}
	public void testContentOfPage() throws Exception
	{
		request.setResource("files");
		request.addInput("filename", "MyFile.txt");
		Responder responder = new DeleteConfirmationResponder();
		SimpleResponse response = (SimpleResponse)responder.makeResponse(context, request);
		String content = response.getContent();

		assertSubString("deleteFile", content);
		assertSubString("Delete File", content);
		assertSubString("MyFile.txt", content);
	}

}
