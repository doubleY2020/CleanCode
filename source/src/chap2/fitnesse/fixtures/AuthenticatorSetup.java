// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fit.ColumnFixture;
import chap2.fitnesse.authentication.OneUserAuthenticator;

public class AuthenticatorSetup extends ColumnFixture
{
	public String username;
	public String password;

	public String status()
	{
		FitnesseFixtureContext.context.authenticator = new OneUserAuthenticator(username, password);
		return "ok";
	}
}
