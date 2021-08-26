package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_EXTERNAL_ARRAY = 10;
    private static final int SIZE_INTERNAL_ARRAY = 2;
    private static final int KEY_POSITION = 0;
    private static final int VALUE_POSITION = 1;
    private int size;
    private final Object[][] arrayStorage;

    public StorageImpl() {
        arrayStorage =
                new Object[SIZE_EXTERNAL_ARRAY][SIZE_INTERNAL_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        if (size > SIZE_EXTERNAL_ARRAY) {
            throw new RuntimeException("Array is full");
        }
        for (int i = 0; i < size; i++) {
            if ((arrayStorage[i][KEY_POSITION] == key)
                    || (key != null && key.equals(arrayStorage[i][KEY_POSITION]))) {
                arrayStorage[i][VALUE_POSITION] = value;
                return;
            }
        }
        arrayStorage[size][KEY_POSITION] = key;
        arrayStorage[size][VALUE_POSITION] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == arrayStorage[i][KEY_POSITION]
                    || (key != null && key.equals(arrayStorage[i][KEY_POSITION]))) {
                return (V) arrayStorage[i][VALUE_POSITION];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
