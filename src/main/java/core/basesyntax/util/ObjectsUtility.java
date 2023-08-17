package core.basesyntax.util;

public class ObjectsUtility {
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
