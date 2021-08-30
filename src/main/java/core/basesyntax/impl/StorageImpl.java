package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;
    private static final int INDEX_FOR_NOT_FOUND_ELEMENT = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_MAX_SIZE];
        values = (V[]) new Object[ARRAY_MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            int storageSize = size();
            values[storageSize] = value;
            keys[storageSize] = key;
            size++;
        } else {
            int indexOfKey = indexOfKey(key);
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
        int storageSize = size();
        for (int i = 0; i < storageSize; i++) {
            if (((keys[i] == null) && (key == null))
                    || ((keys[i] != null) && keys[i].equals(key))) {
                return i;
            }
        }
        return INDEX_FOR_NOT_FOUND_ELEMENT;
    }

}
