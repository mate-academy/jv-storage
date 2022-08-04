package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VOLUME = 10;

    private final Object[] values;
    private final Object[] keys;
    private int countObject = 0;

    public StorageImpl() {
        values = new Object[MAX_VOLUME];
        keys = new Object[MAX_VOLUME];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index < 0) {
            values[countObject] = value;
            keys[countObject] = key;
            countObject++;
            return;
        }
        values[index] = value;
        keys[index] = key;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index < 0 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return countObject;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == null && keys[i] == null
                    || (key != null && keys[i] != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
