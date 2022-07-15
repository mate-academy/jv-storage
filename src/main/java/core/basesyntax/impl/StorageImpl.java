package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private static final int PAIR = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private final Object[][] storage = new Object[MAX_ELEMENTS_NUMBER][PAIR];
    private int storageSize = 0;

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            storage[storageSize][KEY_INDEX] = key;
            storage[storageSize][VALUE_INDEX] = value;
            storageSize++;
        } else {
            storage[index][VALUE_INDEX] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) storage[index][VALUE_INDEX];
    }

    @Override
    public int size() {
        return storageSize;
    }

    public int getIndex(K key) {
        int index = -1;
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (key != null && key.equals(storage[i][KEY_INDEX])
                    || (key == null && storage[i][KEY_INDEX] == null
                    && storage[i][VALUE_INDEX] != null)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
