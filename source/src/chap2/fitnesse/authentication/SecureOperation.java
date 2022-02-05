// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.authentication;

import chap2.fitnesse.http.Request;
import chap2.fitnesse.FitNesseContext;

public interface SecureOperation
{
  public abstract boolean shouldAuthenticate(FitNesseContext context, Request request) throws Exception;
}
