package core.basesyntax.impl;

import java.util.Objects;

public class Data<K, V> {
    private K key;
    private V value;

    public Data(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data current = (Data) o;
        return Objects.equals(key, current.key)
                && Objects.equals(value, current.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Data{"
                + "key='" + key + '\''
                + ", value='" + value + '\''
                + '}';
    }
}
