// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fit.*;

public class ClasspathPrintingFixture extends Fixture
{
	public void doTable(Parse table)
	{
		table.parts.parts.addToBody("<br>classpath: " + System.getProperty("java.class.path"));
	}
}
