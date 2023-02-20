package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_NUMBER = 10;
    public static final int MAX_ELEMENTS_NUMBER = 2;
    public static final int KEY_INDEX = 0;
    public static final int VALUE_INDEX = 1;
    private final Object[][] values = new Object[MAX_ITEMS_NUMBER][MAX_ELEMENTS_NUMBER];

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (isEmpty(i)
                        || values[i][KEY_INDEX] == null && values[i][VALUE_INDEX] != null) {
                    values[i][VALUE_INDEX] = value;
                    return;
                }
            }
        }
        if (get(key) == null) {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (isEmpty(i)) {
                    values[i][KEY_INDEX] = key;
                    values[i][VALUE_INDEX] = value;
                    return;
                }
            }
        } else {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (keyEquals(i, key)) {
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
            if (keyEquals(i, key)) {
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

    public boolean keyEquals(int i, K key) {
        return values[i][KEY_INDEX] != null && values[i][KEY_INDEX].equals(key);
    }

    public boolean isEmpty(int i) {
        return values[i][KEY_INDEX] == null && values[i][VALUE_INDEX] == null;
    }
}
