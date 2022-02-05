// Modified or written by Object Mentor, Inc. for inclusion with FitNesse.
// Copyright (c) 2002 Cunningham & Cunningham, Inc.
// Released under the terms of the GNU General Public License version 2 or later.
package chap2.fit;

public class DotNetFitServerTest extends FitServerTest
{
  protected String command()
  {
    return "dotnet/FitServer.exe -v dotnet\\fit.dll";
  }

  protected String simpleTable(String fixtureName)
  {
    return "<table>" +
      "<tr><td>fit." + fixtureName + "</td></tr>" +
      "</table>";
  }
}
