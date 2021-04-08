package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_NUMBERS = 10;
    private Object[] keys;
    private Object[] values;
    private int currentSize;

    public StorageImpl() {
        this.keys = new Object[MAX_ELEMENT_NUMBERS];
        this.values = new Object[MAX_ELEMENT_NUMBERS];
        this.currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                this.values[i] = value;
                return;
            }
        }
        this.values[currentSize] = value;
        this.keys[currentSize] = key;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((keys[i] == key)
                    || ((keys[i] != null && keys[i].equals(key)))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
