// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fitnesse.responders.ResponderFactory;
import chap2.fitnesse.wiki.FileSystemPage;
import chap2.fit.Fixture;

public class FileSystemPageSetUp extends Fixture
{
	public FileSystemPageSetUp() throws Exception
	{
		FitnesseFixtureContext.root = FileSystemPage.makeRoot(FitnesseFixtureContext.baseDir,"RooT");
		FitnesseFixtureContext.responderFactory = new ResponderFactory(FitnesseFixtureContext.baseDir);
	}
}
