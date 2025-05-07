package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_EXTERNAL_ARRAY = 10;
    private static final int SIZE_INTERNAL_ARRAY = 2;
    private static final int KEY_POSITION = 0;
    private static final int VALUE_POSITION = 1;
    private int size;
    private final Object[][] items;

    public StorageImpl() {
        items = new Object[SIZE_EXTERNAL_ARRAY][SIZE_INTERNAL_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(items[i][KEY_POSITION])
                    || (items[i][KEY_POSITION] == key)) {
                items[i][VALUE_POSITION] = value;
                return;
            }
        }
        if (size > SIZE_EXTERNAL_ARRAY) {
            throw new RuntimeException("Array is full!");
        }
        items[size][KEY_POSITION] = key;
        items[size][VALUE_POSITION] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == items[i][KEY_POSITION]
                    || (key != null && key.equals(items[i][KEY_POSITION]))) {
                return (V) items[i][VALUE_POSITION];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
