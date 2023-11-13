package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_CAPACITY = 10;
    private final Object[] keys = new Object[MAX_CAPACITY];
    private final Object[] values = new Object[MAX_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            keys[keyIndex] = key;
            values[keyIndex] = value;
            return;
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return keyIndex == -1 ? null : (V) values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return i;
            }
        }

        return -1;
    }
}
