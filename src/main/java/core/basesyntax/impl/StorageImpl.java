package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE];
        this.values = (V[]) new Object[MAX_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index >= 0) {
            this.values[index] = value;
        } else {
            this.values[size] = value;
            this.keys[size] = key;
            this.size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
