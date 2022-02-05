// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.search;

import chap2.fitnesse.components.WhereUsed;
import chap2.fitnesse.html.HtmlUtil;

public class WhereUsedResponder extends ResultResponder
{
	protected String getPageFooterInfo(int hits) throws Exception
	{
		return HtmlUtil.makeLink(getRenderedPath(), page.getName()).html() + " is used in " + hits + " page(s).";
	}

	protected void startSearching() throws Exception
	{
		new WhereUsed(root).searchForReferencingPages(page, this);
	}

	protected String getTitle() throws Exception
	{
		return "Where Used Results";
	}

}
