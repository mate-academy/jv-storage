package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int KEY_CELLS = 0;
    private static final int VALUE_CELLS = 1;
    private static final int GENERICS_TYPE_COUNT = 2;
    private static final int MAX_ELEMENTS_COUNT = 10;
    private final Object[][] storage;
    private int size;

    public StorageImpl() {
        storage = new Object[GENERICS_TYPE_COUNT][MAX_ELEMENTS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            storage[VALUE_CELLS][index] = value;
            return;
        }
        storage[KEY_CELLS][size] = key;
        storage[VALUE_CELLS][size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) storage[VALUE_CELLS][index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int index = 0; index < size; index++) {
            if (key == storage[KEY_CELLS][index]
                    || storage[KEY_CELLS][index] != null
                    && storage[KEY_CELLS][index].equals(key)) {
                return index;
            }
        }
        return -1;
    }
}
