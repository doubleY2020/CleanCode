// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.authentication;

import chap2.fitnesse.wiki.*;

public class SecureWriteOperation extends SecurePageOperation
{
  protected String getSecurityMode()
  {
    return WikiPage.SECURE_WRITE;
  }
}
