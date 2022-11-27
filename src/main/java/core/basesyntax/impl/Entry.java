package core.basesyntax.impl;

public class Entry<K, V> {
    private V value;
    private K key;

    public Entry(K key, V value) {
        this.value = value;
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
