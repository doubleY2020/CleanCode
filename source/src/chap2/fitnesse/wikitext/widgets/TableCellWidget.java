// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.wikitext.widgets;

import chap2.fitnesse.wikitext.WidgetBuilder;
import chap2.fitnesse.html.HtmlTag;
import java.util.regex.*;

public class TableCellWidget extends ParentWidget
{
	private static Pattern NEWLINE_PATTERN = Pattern.compile("\\\\(" + LineBreakWidget.REGEXP + ")");

	private TableRowWidget parentRow = null;
	private boolean isLiteral;

	public TableCellWidget(TableRowWidget parentRow, String text, boolean isLiteral) throws Exception
	{
		super(parentRow);
		this.parentRow = parentRow;
		this.isLiteral = isLiteral;
		addChildWidgets(groomText(text));
	}

	private String groomText(String text)
	{
		text = text.replaceAll("\\\\\\r", "\r").replaceAll("\\\\\\n", "\n");
		return text.trim();
	}

	public String render() throws Exception
	{
		return makeCellTag();
	}

	private String makeCellTag() throws Exception
	{
		HtmlTag cellTag = new HtmlTag("td");
		if(computeColSpan().length() > 0)
		{
			cellTag.addAttribute("colspan", computeColSpan());
		}
		if(childHtml().equals(""))
			cellTag.add("&nbsp;");
		else
			cellTag.add(childHtml());
		return cellTag.html();
	}

	private String computeColSpan()
	{
		int currentColumn = parentRow.children.indexOf(this) + 1;
		int maxTableColumn = parentRow.getParentTable().getColumns();
		int maxColumnThisRow = parentRow.numberOfChildren();

		String colspan = "";
		if(currentColumn == maxColumnThisRow && currentColumn != maxTableColumn)
		{
			colspan = String.valueOf(maxTableColumn - currentColumn + 1);
		}
		return colspan;
	}

	public WidgetBuilder getBuilder()
	{
		if(isLiteral)
			return WidgetBuilder.literalAndVariableWidgetBuilder;
		else
			return parent.getBuilder();
	}
}

