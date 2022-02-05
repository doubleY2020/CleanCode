// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.components;

import chap2.fitnesse.wiki.*;
import chap2.fitnesse.wikitext.*;

public class PageReferenceRenamer extends ReferenceRenamer
{
	private WikiPage subjectPage;
	private String newName;

	public PageReferenceRenamer(WikiPage root)
	{
		super(root);
	}

	public void renameReferences(WikiPage subjectPage, String newName) throws Exception
	{
		this.subjectPage = subjectPage;
		this.newName = newName;
		renameReferences();
	}

	protected WidgetVisitor getVisitor()
	{
		return new PageReferenceRenamingVisitor(subjectPage, newName);
	}

	public String getSearchPattern() throws Exception
	{
		return subjectPage.getName();
	}
}
