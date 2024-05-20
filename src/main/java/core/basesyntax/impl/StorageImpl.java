package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_COLLECTION_SIZE = 10;
    private Object[] keys = new Object[MAX_COLLECTION_SIZE];
    private Object[] values = new Object[MAX_COLLECTION_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null ? key.equals(keys[i]) : key == keys[i]) {
                values[i] = value;
                break;
            } else if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null ? key.equals((K) keys[i]) : keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                count++;
            }
        }
        return count;
    }
}
