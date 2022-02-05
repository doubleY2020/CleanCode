// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.wikitext.widgets;

import chap2.fitnesse.wikitext.WikiWidget;
import chap2.fitnesse.html.HtmlUtil;
import java.util.regex.*;

public class AnchorDeclarationWidget extends WikiWidget
{

	public static final String REGEXP = "!anchor \\w+";
	private static final Pattern pattern = Pattern.compile("!anchor (\\w*)");

	private String text, anchorName;

	public AnchorDeclarationWidget(ParentWidget parent, String text)
	{
		super(parent);
		this.text = text;
		Matcher match = pattern.matcher(this.text);
		if(match.find())
			anchorName = match.group(1);
	}

	public String render() throws Exception
	{
		return HtmlUtil.makeAnchorTag(anchorName).html();
	}
}
