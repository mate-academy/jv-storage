package core.basesyntax;

import java.util.Arrays;

public class TypedArray<T> {
    private final Object[] objectArray;

    public TypedArray(int length) {
        objectArray = new Object [length];
    }

    public T getElement(int elIndex) {
        @SuppressWarnings("unchecked")
        final T element = (T) objectArray[elIndex];
        return element;
    }

    public void setElement(int elIndex, T value) {
        objectArray[elIndex] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(objectArray);
    }
}
