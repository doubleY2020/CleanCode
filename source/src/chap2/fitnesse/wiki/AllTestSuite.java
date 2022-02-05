// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.wiki;

import junit.framework.Test;
import chap2.fitnesse.testutil.TestSuiteMaker;

public class AllTestSuite
{
	public static Test suite()
	{
		return TestSuiteMaker.makeSuite("wiki", new Class[] {
			CachingPageTest.class,
			VirtualCouplingExtensionTest.class,
			FileSystemPageTest.class,
			ProxyPageTest.class,
			PageDataTest.class,
			FileSystemPageVersioningTest.class,
			WikiPagePropertiesTest.class,
			FixtureListBuilderTest.class,
			PageCrawlerTest.class,
			VirtualEnabledPageCrawlerTest.class,
			MockingPageCrawlerTest.class,
			VersionInfoTest.class,
			ExtendableWikiPageTest.class,
			InMemoryPageTest.class,
      WikiPagePathTest.class,
      PathParserTest.class,
      PageXmlizerTest.class,
      SymbolicPageTest.class,
      BaseWikiPageTest.class,
			WikiPagePropertyTest.class
		});
	}
}