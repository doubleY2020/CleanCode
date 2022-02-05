// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.testutil;

import chap2.fitnesse.responders.run.*;
import java.net.Socket;

public class SimpleSocketSeeker implements SocketSeeker
{
	public SocketDoner doner;
	public Socket socket;

	public void acceptSocketFrom(SocketDoner doner) throws Exception
	{
		this.doner = doner;
		this.socket = doner.donateSocket();
	}
}
