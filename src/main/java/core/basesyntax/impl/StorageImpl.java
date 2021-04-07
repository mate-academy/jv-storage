package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private Object[] keys;
    private Object[] values;
    private int count;

    public StorageImpl() {
        keys = new Object[ARRAY_LENGTH];
        values = new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int oldIndex = getIndexOf(key);
        if (oldIndex != INDEX_NOT_FOUND) {
            keys[oldIndex] = key;
            values[oldIndex] = value;
            return;
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        int oldIndex = getIndexOf(key);
        if (oldIndex != INDEX_NOT_FOUND) {
            return (V) values[oldIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private int getIndexOf(K key) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
}
