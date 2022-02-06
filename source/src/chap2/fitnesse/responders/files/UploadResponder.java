// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chap2.fitnesse.FitNesseContext;
import chap2.fitnesse.authentication.AlwaysSecureOperation;
import chap2.fitnesse.authentication.SecureOperation;
import chap2.fitnesse.http.Request;
import chap2.fitnesse.http.Response;
import chap2.fitnesse.http.SimpleResponse;
import chap2.fitnesse.http.UploadedFile;
import chap2.fitnesse.responders.SecureResponder;
import chap2.fitnesse.util.FileUtil;

public class UploadResponder implements SecureResponder
{
	private static final Pattern filenamePattern = Pattern.compile("([^/\\\\]*[/\\\\])*([^/\\\\]*)");

	private String rootPath;

	public Response makeResponse(FitNesseContext context, Request request) throws Exception
	{
    rootPath = context.rootPagePath;
		SimpleResponse response = new SimpleResponse();
		String resource = request.getResource().replace("%20", " ");
		UploadedFile uploadedFile = (UploadedFile) request.getInput("file");
		if(uploadedFile.isUsable())
		{
			File file = makeFileToCreate(uploadedFile, resource);
			writeFile(file, uploadedFile);
		}

		response.redirect("/" +resource.replace(" ", "%20"));
		return response;
	}

	public void writeFile(File file, UploadedFile uploadedFile) throws Exception
	{
		boolean renamed = uploadedFile.getFile().renameTo(file);
		if(!renamed)
		{
			InputStream input = new BufferedInputStream(new FileInputStream(uploadedFile.getFile()));
			OutputStream output = new BufferedOutputStream(new FileOutputStream(file));
			FileUtil.copyBytes(input, output);
			input.close();
			output.close();
			uploadedFile.delete();
		}
	}

	private File makeFileToCreate(UploadedFile uploadedFile, String resource)
	{
		String relativeFilename = makeRelativeFilename(uploadedFile.getName());
		String filename = relativeFilename;
		int prefix = 1;
		File file = new File(makeFullFilename(resource, filename));
		while(file.exists())
		{
			filename = makeNewFilename(relativeFilename, prefix++);
			file = new File(makeFullFilename(resource, filename));
		}
		return file;
	}

	private String makeFullFilename(String resource, String filename)
	{
		return rootPath + "/" + resource + filename;
	}

	public static String makeRelativeFilename(String name)
	{
		Matcher match = filenamePattern.matcher(name);
		if(match.find())
			return match.group(2);
		else
			return name;
	}

	public static String makeNewFilename(String filename, int copyId)
	{
		String[] parts = filename.split("\\.");

		if(parts.length == 1)
			return filename + "_copy" + copyId;
		else
		{
			String newName = "";
			for(int i = 0; i < parts.length - 1; i++)
			{
				if(i != 0)
					newName += ".";
				newName += parts[i];
			}
			newName += "_copy" + copyId + "." + parts[parts.length - 1];
			return newName;
		}
	}

	public SecureOperation getSecureOperation()
	{
		return new AlwaysSecureOperation();
	}
}