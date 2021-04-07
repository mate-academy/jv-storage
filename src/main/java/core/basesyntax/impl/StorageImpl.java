package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private K[] arrayKeys;
    private V[] arrayValues;
    private int index;

    public StorageImpl() {
        arrayKeys = (K[]) new Object[MAX_STORAGE_CAPACITY];
        arrayValues = (V[]) new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (key == arrayKeys[i] || key != null && key.equals(arrayKeys[i])) {
                arrayValues[i] = value;
                return;
            }
        }
        arrayKeys[index] = key;
        arrayValues[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == arrayKeys[i] || key != null && key.equals(arrayKeys[i])) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
