package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int INDEX_OF_NOTHING = -1;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            reWrite(key, value);
        } else {
            newWrite(key, value);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return (index != INDEX_OF_NOTHING)
                ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return INDEX_OF_NOTHING;
    }

    public void newWrite(K key, V value) {
        for (int i = 0; i < values.length; i++) {
            if (keys[i] == null && values[i] == null) {
                values[i] = value;
                keys[i] = key;
                size++;
                return;
            }
        }
    }

    public void reWrite(K key, V value) {
        int index = getKeyIndex(key);
        values[index] = value;
        keys[index] = key;
    }
}
