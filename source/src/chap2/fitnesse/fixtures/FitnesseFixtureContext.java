// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.fixtures;

import chap2.fitnesse.wiki.WikiPage;
import chap2.fitnesse.http.*;
import chap2.fitnesse.responders.ResponderFactory;
import chap2.fitnesse.*;

public class FitnesseFixtureContext
{
	public static WikiPage root;
	public static WikiPage page;
	public static Response response;
	public static MockResponseSender sender;
	public static ResponderFactory responderFactory;
	public static String baseDir = "temp";
  public static FitNesseContext context;
	public static FitNesse fitnesse;
}
