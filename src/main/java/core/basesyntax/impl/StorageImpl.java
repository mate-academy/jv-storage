package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private static final int STORAGE_KEY_VALUE_SIZE = 2;
    private static final int STORAGE_KEY_INDEX = 0;
    private static final int STORAGE_VALUE_INDEX = 1;
    private int size = 0;
    private Object[][] items;

    public StorageImpl() {
        items = new Object[STORAGE_SIZE][STORAGE_KEY_VALUE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((items[i][STORAGE_KEY_INDEX] != null && items[i][STORAGE_KEY_INDEX].equals(key))
                    || (key == items[i][STORAGE_KEY_INDEX])) {
                items[i][STORAGE_VALUE_INDEX] = value;
                return;
            }
        }
        items[size][STORAGE_KEY_INDEX] = key;
        items[size][STORAGE_VALUE_INDEX] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(items[i][STORAGE_KEY_INDEX])
                    || key == items[i][STORAGE_KEY_INDEX]) {
                return (V) items[i][STORAGE_VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
