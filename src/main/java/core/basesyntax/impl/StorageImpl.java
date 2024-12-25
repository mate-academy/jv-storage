package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int existingIndex = indexOfExistingKey(key);
        if (existingIndex != -1) {
            values[existingIndex] = value;
            return;
        }
        int currentSize = size();
        if (currentSize < CAPACITY) {
            keys[currentSize] = key;
            values[currentSize] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int indexToFind = indexOfExistingKey(key);
        if (indexToFind != -1) {
            return values[indexToFind];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public int indexOfExistingKey(K key) {
        for (int i = 0; i < size(); i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
