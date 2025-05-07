package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int AMOUNT_OF_ARRAYS = 2;
    private static final int AMOUNT_OF_ITEMS = 10;
    private static final int INDEX_OF_KEYS = 0;
    private static final int INDEX_OF_VALUES = 1;
    private Object[][] dictionary;
    private int size;

    public StorageImpl() {
        dictionary = new Object[AMOUNT_OF_ARRAYS][AMOUNT_OF_ITEMS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != -1) {
            dictionary[INDEX_OF_VALUES][index] = value;
            return;
        }
        if (size < AMOUNT_OF_ITEMS) {
            dictionary[INDEX_OF_KEYS][size] = key;
            dictionary[INDEX_OF_VALUES][size++] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index != -1) {
            return (V) dictionary[INDEX_OF_VALUES][index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (dictionary[INDEX_OF_KEYS][i] == key
                    || key != null
                    && key.equals(dictionary[INDEX_OF_KEYS][i])) {
                return i;
            }
        }
        return -1;
    }
}
