// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.wikitext.widgets;

import chap2.fitnesse.wiki.WikiPageDummy;
import chap2.fitnesse.wikitext.WidgetBuilder;
import junit.framework.TestCase;

import java.util.List;

public class TextIgnoringWidgetRootTest extends TestCase {
  public void setUp() throws Exception {
  }

  public void tearDown() throws Exception {
  }

  public void testNoTextWidgetAreCreated() throws Exception {
    String text = "Here is some text with '''bold''' and ''italics''.";
    WikiPageDummy page = new WikiPageDummy("SomePage", text);
    WidgetRoot root = new TextIgnoringWidgetRoot(text, page, WidgetBuilder.htmlWidgetBuilder);
    List widgets = root.getChildren();
    assertEquals(2, widgets.size());
    assertTrue(widgets.get(0) instanceof BoldWidget);
    assertTrue(widgets.get(1) instanceof ItalicWidget);
  }

}
