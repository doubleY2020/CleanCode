// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders.search;

import junit.framework.*;
import chap2.fitnesse.testutil.TestSuiteMaker;

public class AllTestSuite
{
	public static Test suite()
	{
		return TestSuiteMaker.makeSuite("search", new Class[] {
			SearchFormResponderTest.class,
			SearchResponderTest.class,
			WhereUsedResponderTest.class
		});
	}
}

