package chap2.fitnesse.testutil;

import java.awt.Point;

import chap2.fit.TypeAdapter;

public class ObjectTranslatePoint extends TranslatePoint
{
    static {
        TypeAdapter.registerParseDelegate(Point.class, new ObjectDelegatePointParser());
    }
}
