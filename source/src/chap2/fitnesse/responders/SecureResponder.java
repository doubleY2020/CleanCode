// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders;

import chap2.fitnesse.Responder;
import chap2.fitnesse.authentication.SecureOperation;

public interface SecureResponder extends Responder
{
	SecureOperation getSecureOperation();
}
