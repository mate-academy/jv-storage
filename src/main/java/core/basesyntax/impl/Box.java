package core.basesyntax.impl;

import java.util.Objects;

public class Box<K, V> {
    private final K key;
    private V value;

    public Box(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public boolean equalsKey(Object key) {
        return Objects.equals(this.key, key);
    }
}
