// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.testutil;

import java.net.Socket;
import chap2.fitnesse.testutil.MockSocket;
import chap2.fitnesse.responders.run.SocketDoner;

public class SimpleSocketDoner implements SocketDoner
{
	public Socket socket;
	public boolean finished = false;

	public SimpleSocketDoner()
	{
		socket = new MockSocket("SimpleSocketDoner");
	}

	public SimpleSocketDoner(Socket socket)
	{
		this.socket = socket;
	}

	public Socket donateSocket()
	{
		return socket;
	}

	public void finishedWithSocket() throws Exception
	{
		finished = true;
		socket.close();
	}
}
