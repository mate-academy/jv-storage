package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys = new Object[MAX_ITEMS_NUMBER];
    private Object[] values = new Object[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    values[i] = value;
                    break;
                } else {
                    continue;
                }
            }
            if (key.equals(keys[i])) {
                values [i] = value;
                break;
            }
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return (V) values[i];
                } else {
                    continue;
                }
            }
            if (key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int storageSize = 0;
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (keys[i] != null || values[i] != null) {
                storageSize++;
            }
        }
        return storageSize;
    }
}
