package chap2.fit.decorator;

import chap2.fit.Fixture;
import chap2.fit.Parse;
import chap2.fit.decorator.util.Table;

public class TestFixture extends Fixture
{
    public static final String TABLE_CONTENTS = "tableContents";

    public TestFixture()
    {
        super.summary.put(FixtureDecorator.ENCAPSULATED_FIXTURE_NAME, TestFixture.class.getName());
    }

    public void doTable(Parse table)
    {
        super.summary.put(TABLE_CONTENTS, new Table(table).toString());
    }
}
