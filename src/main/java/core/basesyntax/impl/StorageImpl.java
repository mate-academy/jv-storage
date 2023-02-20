package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_NUMBER = 10;
    public static final int MAX_ELEMENTS_NUMBER = 2;
    public static final int KEY_INDEX = 0;
    public static final int VALUE_INDEX = 1;
    private Object[][] values = new Object[MAX_ITEMS_NUMBER][MAX_ELEMENTS_NUMBER];

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (values[i][KEY_INDEX] == null && values[i][VALUE_INDEX] == null
                        || values[i][KEY_INDEX] == null && values[i][VALUE_INDEX] != null) {
                    values[i][VALUE_INDEX] = value;
                    return;
                }
            }
        }
        if (get(key) == null) {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (values[i][KEY_INDEX] == null && values[i][VALUE_INDEX] == null) {
                    values[i][KEY_INDEX] = key;
                    values[i][VALUE_INDEX] = value;
                    return;
                }
            }
        } else {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (values[i][KEY_INDEX] != null && values[i][KEY_INDEX].equals(key)) {
                    values[i][VALUE_INDEX] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (values[i][KEY_INDEX] == null && values[i][VALUE_INDEX] != null) {
                    return (V) values[i][VALUE_INDEX];
                }
            }
        }

        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (values[i][KEY_INDEX] != null && values[i][KEY_INDEX].equals(key)) {
                return (V) values[i][VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (values[i][VALUE_INDEX] != null) {
                size++;
            }
        }
        return size;
    }
}
