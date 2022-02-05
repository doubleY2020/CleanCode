// Modified or written by Object Mentor, Inc. for inclusion with FitNesse.
// Copyright (c) 2002 Cunningham & Cunningham, Inc.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fit.exception;

import chap2.fit.exception.FitFailureException;

public class NoSuchMethodFitFailureException extends FitFailureException
{
  public NoSuchMethodFitFailureException(String name)
  {
    super("Could not find method: " + name + ".");
  }
}
