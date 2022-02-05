// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fit.Fixture;

public class CountFixture extends Fixture {
  private int counter = 0;

	public void count() {
    counter++;
  }

  public int counter() {
    return counter;
  }

  public void counter(int i) {
    counter = i;
  }
}


