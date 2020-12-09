package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY_KEYS = 10;
    private static final int INITIAL_CAPACITY_VALUES = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private int incrementedIndex = 0;
    private Object[][] storage;

    public StorageImpl() {
        storage = new Object[INITIAL_CAPACITY_KEYS][INITIAL_CAPACITY_VALUES];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) != -1) {
            storage[indexOf(key)][VALUE_INDEX] = value;
        } else {
            storage[incrementedIndex][KEY_INDEX] = key;
            storage[incrementedIndex][VALUE_INDEX] = value;
            incrementedIndex++;
        }
    }

    @Override
    public V get(K key) {
        if (indexOf(key) == -1) {
            return null;
        }
        return (V) storage[indexOf(key)][VALUE_INDEX];
    }

    private int indexOf(K key) {
        int index = -1;
        for (int i = 0; i < storage.length; i++) {
            if (key != null ? key.equals(storage[i][KEY_INDEX]) : storage[i][KEY_INDEX] == key) {
                index = i;
            }
        }
        return index;
    }
}
