// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.files;

import chap2.fitnesse.*;
import chap2.fitnesse.responders.SecureResponder;
import chap2.fitnesse.authentication.*;
import chap2.fitnesse.http.*;
import java.io.File;

public class CreateDirectoryResponder implements SecureResponder
{
	public Response makeResponse(FitNesseContext context, Request request) throws Exception
	{
		SimpleResponse response = new SimpleResponse();

		String resource = request.getResource();
		String dirname = (String) request.getInput("dirname");
		String pathname = context.rootPagePath + "/" + resource + dirname;
		File file = new File(pathname);
		if(!file.exists())
			file.mkdir();

		response.redirect("/" + resource);
		return response;
	}

	public SecureOperation getSecureOperation()
	{
		return new AlwaysSecureOperation();
	}
}
