package core.basesyntax.impl;

public class MyBox<K, V> {
    private K key;
    private V value;

    public MyBox(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
