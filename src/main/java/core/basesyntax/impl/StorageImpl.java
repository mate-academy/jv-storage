package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int AMOUNT_OF_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[AMOUNT_OF_ELEMENTS];
        values = (V[])new Object[AMOUNT_OF_ELEMENTS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size > AMOUNT_OF_ELEMENTS) {
            return;
        }

        int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            values[keyIndex] = value;
        } else {
            keys[size] = key;
            values[size++] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        return keyIndex == -1 ? null : values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
