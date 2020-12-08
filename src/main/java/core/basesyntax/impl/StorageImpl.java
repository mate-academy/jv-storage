package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private int incrementedIndex = 0;
    private Object[][] storage;

    public StorageImpl() {
        storage = new Object[INITIAL_CAPACITY][INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        Object[] result = isContains(key);
        if ((boolean) result[0] == true) {
            storage[(int) result[1]][VALUE_INDEX] = value;
        } else {
            storage[incrementedIndex][KEY_INDEX] = key;
            storage[incrementedIndex][VALUE_INDEX] = value;
            incrementedIndex++;
        }
    }

    @Override
    public V get(K key) {
        Object[] result = isContains(key);
        return (V) result[2];
    }

    private Object[] isContains(K key) {
        Object[] result = new Object[3];
        result[0] = false;
        result[1] = 0;
        result[2] = null;
        for (int i = 0; i < storage.length; i++) {
            if (key != null ? key.equals(storage[i][KEY_INDEX]) : storage[i][KEY_INDEX] == key) {
                result[0] = true;
                result[1] = i;
                result[2] = storage[i][VALUE_INDEX];
            }
        }
        return result;
    }
}
