package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = (K[])new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < 10; i++) {
            if (keys[i] == null & values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
            if (keys[i] == null & key == null) {
                values[i] = value;
                break;
            }
            if (keys[i] != null) {
                if (keys[i].equals(key)) {
                    values[i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < 10; i++) {
            if (keys[i] == null) {
                if (key == null) {
                    return (V) values[i];
                } else {
                    continue;
                }
            }
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (keys[i] != null || values[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
