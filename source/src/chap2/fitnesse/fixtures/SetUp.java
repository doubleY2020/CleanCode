// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fit.Fixture;
import chap2.fitnesse.wiki.InMemoryPage;
import chap2.fitnesse.responders.*;
import chap2.fitnesse.*;

public class SetUp extends Fixture
{
  public SetUp() throws Exception
  {
	  //TODO - MdM - There's got to be a better way.
	  WikiImportTestEventListener.register();

    FitnesseFixtureContext.root = InMemoryPage.makeRoot("RooT");
    FitnesseFixtureContext.responderFactory = new ResponderFactory(FitnesseFixtureContext.baseDir + "/RooT/");
    FitnesseFixtureContext.context = new FitNesseContext(FitnesseFixtureContext.root);
	  FitnesseFixtureContext.context.responderFactory = FitnesseFixtureContext.responderFactory;
    FitnesseFixtureContext.context.port = 9123;
    FitnesseFixtureContext.context.rootPagePath = FitnesseFixtureContext.baseDir;
	  FitnesseFixtureContext.fitnesse = new FitNesse(FitnesseFixtureContext.context, false);

	  FitnesseFixtureContext.fitnesse.start();
  }
}
