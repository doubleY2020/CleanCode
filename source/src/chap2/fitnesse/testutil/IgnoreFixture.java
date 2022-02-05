// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.testutil;

import chap2.fit.*;

public class IgnoreFixture extends Fixture
{
	public void doTable(Parse table)
	{
		ignore(table.parts.parts);
	}
}
