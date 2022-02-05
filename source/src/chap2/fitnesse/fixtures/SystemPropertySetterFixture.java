// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fit.ColumnFixture;

public class SystemPropertySetterFixture extends ColumnFixture
{
	public String key;
	public String value;
	public void execute() {
		System.getProperties().setProperty(key, value);
	}
}
