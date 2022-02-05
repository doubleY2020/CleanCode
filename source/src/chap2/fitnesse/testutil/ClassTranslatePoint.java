package chap2.fitnesse.testutil;

import java.awt.Point;

import chap2.fit.TypeAdapter;

public class ClassTranslatePoint extends TranslatePoint
{
    static
    {
        TypeAdapter.registerParseDelegate(Point.class, ClassDelegatePointParser.class);
    }
}
