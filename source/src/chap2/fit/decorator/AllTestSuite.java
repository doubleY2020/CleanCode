package chap2.fit.decorator;

import junit.framework.Test;
import chap2.fit.decorator.performance.MaxTimeTest;
import chap2.fit.decorator.performance.TimeRangeTest;
import chap2.fit.decorator.util.DataTypeTest;
import chap2.fit.decorator.util.DeltaTest;
import chap2.fit.decorator.util.TableTest;
import chap2.fitnesse.testutil.TestSuiteMaker;

public class AllTestSuite
{
    public static Test suite()
    {
        return TestSuiteMaker.makeSuite("fit.decorator", new Class[] {
            CopyAndAppendLastRowTest.class,
            IncrementColumnsValueTest.class,
            LoopTest.class,
            MaxTimeTest.class,
            TimeRangeTest.class,
            DeltaTest.class,
            TableTest.class,
            DataTypeTest.class
        });
  }
}
