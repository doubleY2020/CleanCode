package chap2.fit.decorator;

import chap2.fit.Fixture;
import chap2.fit.Parse;
import chap2.fit.decorator.exceptions.InvalidInputException;

public class Loop extends FixtureDecorator
{
    public static final String COUNT = "count";
    private int counter;

    protected void run(Fixture fixture, Parse table)
    {
        for (int i = 0; i < counter; i++)
        {
            super.run(fixture, table);
        }
    }

    protected void setupDecorator(String[] arguments) throws InvalidInputException
    {
        if (arguments.length != 1)
        {
            throw new InvalidInputException("Loop count must be specified");
        }
        counter = Integer.parseInt(arguments[0]);
        summary.put(COUNT, new Long(counter));
    }

    protected void updateColumnsBasedOnResults(Parse table)
    {
        // Nothing to do
    }
}
