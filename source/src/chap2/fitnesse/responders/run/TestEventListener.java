package chap2.fitnesse.responders.run;

import chap2.fitnesse.wiki.*;

public interface TestEventListener
{
	void notifyPreTest(TestResponder testResponder, PageData data) throws Exception;
}
