package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int ITEM_FIELDS = 2;
    private static final int KEY_COLUMN_INDEX = 0;
    private static final int VALUE_COLUMN_INDEX = 1;
    private static final int DEFAULT_STORAGE_SIZE = 0;
    private Object[][] items;
    private int size;

    public StorageImpl() {
        items = new Object[MAX_ITEMS_NUMBER][ITEM_FIELDS];
        size = DEFAULT_STORAGE_SIZE;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeyEquals(key, (K) items[i][KEY_COLUMN_INDEX])) {
                items[i][VALUE_COLUMN_INDEX] = value;
                return;
            }
        }
        items[size][KEY_COLUMN_INDEX] = key;
        items[size][VALUE_COLUMN_INDEX] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < items.length; i++) {
            if (isKeyEquals(key, (K) items[i][KEY_COLUMN_INDEX])) {
                return (V) items[i][VALUE_COLUMN_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyEquals(K firstKey, K secondKey) {
        return firstKey == null ? secondKey == null : firstKey.equals(secondKey);
    }
}
