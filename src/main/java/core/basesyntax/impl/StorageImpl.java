package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_RAW = 10;
    private static final int NUMBER_OF_COLUMN = 2;
    private static final int INDEX_OF_KEY = 0;
    private static final int INDEX_OF_VALUE = 1;
    private final Object[][] pairs = new Object[NUMBER_OF_RAW][NUMBER_OF_COLUMN];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            pairs[size][INDEX_OF_KEY] = key;
            pairs[size][INDEX_OF_VALUE] = value;
            size++;
        } else {
            pairs[index][INDEX_OF_VALUE] = value;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) pairs[index][INDEX_OF_VALUE];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == pairs[i][INDEX_OF_KEY]
                    || (key != null && key.equals(pairs[i][INDEX_OF_KEY]))) {
                return i;
            }
        }
        return -1;
    }
}
