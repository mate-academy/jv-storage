package core.basesyntax.impl;

public class KeyValuePair<T, S> {
    private T key;
    private S value;

    public KeyValuePair(T key, S value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(S value) {
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public S getValue() {
        return value;
    }
}
