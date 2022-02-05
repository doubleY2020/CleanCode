// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fitnesse.responders;

import chap2.fitnesse.FitNesseContext;
import chap2.fitnesse.http.*;
import chap2.fitnesse.testutil.RegexTest;
import chap2.fitnesse.wiki.*;

public class ChunkingResponderTest extends RegexTest {

  private Exception exception;
  private Response response;
  private FitNesseContext context;
  private WikiPage root = new WikiPageDummy();
  private ChunkingResponder responder = new ChunkingResponder() {
    protected void doSending() throws Exception {
      throw exception;
    }
  };

  protected void setUp() throws Exception {
    context = new FitNesseContext();
    context.root = root;
  }

  public void testException() throws Exception {
    exception = new Exception("test exception");
    response = responder.makeResponse(context, new MockRequest());
    String result = new MockResponseSender(response).sentData();
    assertSubString("test exception", result);
  }
}