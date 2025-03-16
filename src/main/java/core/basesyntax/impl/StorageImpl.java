package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private static final int INDEX_ABSENT = -1;
    private int counter = 0;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_CAPACITY];
        values = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (key == null) {
            if (index != INDEX_ABSENT) {
                values[index] = value;
                return;
            }
        }
        if (index != INDEX_ABSENT) {
            keys[index] = key;
            values[index] = value;
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                counter++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        if (key == null) {
            return (index != INDEX_ABSENT) ? values[index] : null;
        }
        return (index != INDEX_ABSENT) ? values[index] : null;
    }

    @Override
    public int size() {
        return counter;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null ? keys[i] == null && values[i] != null
                    : keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return INDEX_ABSENT;
    }
}
