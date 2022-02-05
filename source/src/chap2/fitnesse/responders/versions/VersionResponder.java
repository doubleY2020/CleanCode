// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.versions;

import chap2.fitnesse.http.*;
import chap2.fitnesse.wiki.*;
import chap2.fitnesse.html.*;
import chap2.fitnesse.*;
import chap2.fitnesse.responders.*;
import chap2.fitnesse.authentication.*;

public class VersionResponder implements SecureResponder
{
	private WikiPage page;
	private String version;
	private String resource;

	public Response makeResponse(FitNesseContext context, Request request) throws Exception
	{
		resource = request.getResource();
		version = (String) request.getInput("version");

		PageCrawler pageCrawler = context.root.getPageCrawler();
		WikiPagePath path = PathParser.parse(resource);
		page = pageCrawler.getPage(context.root, path);
		if(page == null)
			return new NotFoundResponder().makeResponse(context, request);
		PageData pageData = page.getDataVersion(version);

		String fullPathName = PathParser.render(pageCrawler.getFullPath(page));
		HtmlPage html = makeHtml(fullPathName, pageData, context);

		SimpleResponse response = new SimpleResponse();
		response.setContent(html.html());

		return response;
	}

	private HtmlPage makeHtml(String name, PageData pageData, FitNesseContext context) throws Exception
	{
		HtmlPage html = context.htmlPageFactory.newPage();
		html.title.use("Version " + version + ": " + name);
		html.header.use(HtmlUtil.makeBreadCrumbsWithPageType(resource, "Version " + version));
		html.actions.use(HtmlUtil.makeActionLink(name, "Rollback", "responder=rollback&version=" + version, "", false));
		html.main.use(HtmlUtil.makeNormalWikiPageContent(pageData));
		return html;
	}

	public SecureOperation getSecureOperation()
	{
		return new SecureReadOperation();
	}
}
