package core.basesyntax.model;

import java.util.Objects;

public class Pair<K,T> {
    private final K key;
    private T value;

    public Pair(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !object.getClass().equals(Pair.class)) {
            return false;
        }
        Pair<?,?> pair = (Pair<?,?>) object;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (key == null ? 0 : key.hashCode());
        result = 31 * result + (value == null ? 0 : value.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Pair{"
                + "key=" + key
                + ", value=" + value
                + '}';
    }
}
