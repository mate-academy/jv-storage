package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int INDEX_FOR_NOT_FOUND_ELEMENT = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey == INDEX_FOR_NOT_FOUND_ELEMENT) {
            values[size] = value;
            keys[size] = key;
            size++;
        } else {
            values[indexOfKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == INDEX_FOR_NOT_FOUND_ELEMENT) {
            return null;
        }
        return values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key)
                    || ((keys[i] != null) && keys[i].equals(key))) {
                return i;
            }
        }
        return INDEX_FOR_NOT_FOUND_ELEMENT;
    }

}
