// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.authentication;

public class PromiscuousAuthenticator extends Authenticator
{
	public boolean isAuthenticated(String username, String password)
	{
		return true;
	}
}