package core.basesyntax.impl;

public class StorageCell<K, V> {
    private K key;
    private V value;

    public StorageCell() {
        this.key = (K) new Object();
        this.value = (V) new Object();
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
