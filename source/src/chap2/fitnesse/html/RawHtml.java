// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.html;

public class RawHtml extends HtmlElement
{
	private String html;

	public RawHtml(String html)
	{
		this.html = html;
	}

	public String html()
	{
		return html;
	}
}
