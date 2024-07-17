package core.basesyntax.impl;

public class KeyValueBox<T, S> {
    private T key;
    private S value;

    public KeyValueBox(T key, S value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public S getValue() {
        return value;
    }
}
