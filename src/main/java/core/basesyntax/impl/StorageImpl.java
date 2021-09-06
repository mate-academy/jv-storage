package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[])(new Object[MAX_ITEMS_NUMBER]);
        values = (V[])(new Object[MAX_ITEMS_NUMBER]);
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Storage capacity exeeded");
        }
        for (int i = 0; i < size; i++) {
            if (equal(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (equal(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean equal(K key, K keyFromArray) {
        return key == keyFromArray || (key != null && key.equals(keyFromArray));
    }
}
