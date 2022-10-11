package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int NOT_FOUND_KEY = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndexInStorage(key);
        if (keyIndex == NOT_FOUND_KEY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndexInStorage(key);
        return keyIndex > -1 ? values[keyIndex] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndexInStorage(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return NOT_FOUND_KEY;
    }
}
