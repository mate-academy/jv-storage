package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private static final int VALUE_INDEX_OFFSET = 1;
    private static final int KEY_NOT_FOUND = -1;
    private static final int ENTRIES_PER_ELEMENT = 2;

    private final Object[] storage = new Object[STORAGE_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int indexOfKey = findKeyIndex(key);

        if (indexOfKey == KEY_NOT_FOUND) {
            storage[size] = key;
            storage[size + VALUE_INDEX_OFFSET] = value;
            size += ENTRIES_PER_ELEMENT;
        } else {
            storage[indexOfKey + VALUE_INDEX_OFFSET] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexOfKey = findKeyIndex(key);

        if (indexOfKey != KEY_NOT_FOUND) {
            return (V) storage[indexOfKey + VALUE_INDEX_OFFSET];
        }
        return null;
    }

    @Override
    public int size() {
        return size / 2;
    }

    private int findKeyIndex(K key) {

        for (int i = 0; i < size; i += ENTRIES_PER_ELEMENT) {
            if (storage[i] == null) {
                if (storage[i] == key) {
                    return i;
                }
            } else if (storage[i].equals(key)) {
                return i;
            }
        }
        return KEY_NOT_FOUND;
    }
}
