// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.testutil;

import chap2.fit.*;

public class EchoFixture extends Fixture
{
	public void doTable(Parse table)
	{
		String text = getArgs()[0];
		table.parts.parts = new Parse("tr", "", new Parse("td", text, null, null), null);
	}
}
