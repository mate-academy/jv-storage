package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < 10; i++) {
            if (key == null || keys[i] == null) {
                if (keys[i] == null && (key == null || values[i] == null)) {
                    keys[i] = key;
                    size += values[i] == null ? 1 : 0;
                    values[i] = value;
                    break;
                }
            } else if (keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < 10; i++) {
            if (keys[i] == null) {
                if (key == null) {
                    return values[i];
                }
            } else if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
