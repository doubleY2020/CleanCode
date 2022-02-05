// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fit.*;

public class Sleep extends Fixture
{
	public void doTable(Parse table)
	{
		String args[] = getArgs();
		long millis = Long.parseLong(args[0]);
		try
		{
			Thread.sleep(millis);
		}
		catch(InterruptedException e)
		{
		}
	}
}
