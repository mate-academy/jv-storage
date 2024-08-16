package core.basesyntax.impl;

public class StorageArray<K, V> {
    private K key;
    private V value;

    public StorageArray(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
