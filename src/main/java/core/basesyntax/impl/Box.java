package core.basesyntax.impl;

public class Box<K, V> {
    private K keys;
    private V values;

    public Box(K key, V values) {
        this.keys = key;
        this.values = values;
    }

    public K getKey() {
        return keys;
    }

    public V getValue() {
        return values;
    }

    public void setValues(V values) {
        this.values = values;
    }
}
