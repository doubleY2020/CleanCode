// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.wikitext.widgets;

import chap2.fitnesse.wiki.*;
import chap2.fitnesse.wikitext.WidgetBuilder;

public class MockWidgetRoot extends WidgetRoot {
  public MockWidgetRoot() throws Exception {
    super(null, new PagePointer(new WikiPageDummy("RooT"), new WikiPagePath()), WidgetBuilder.htmlWidgetBuilder);
  }

  protected void buildWidgets(String value) throws Exception {
  }
}
