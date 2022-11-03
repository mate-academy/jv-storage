package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final byte MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;
    private boolean nullMarker;

    public StorageImpl() {
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (key == null) {
            if (nullMarker) {
                for (int i = 0; i < keys.length; i++) {
                    if (keys[i] == null && size > 0) {
                        values[i] = value;
                        return;
                    }
                }
            }
            values[size] = value;
            nullMarker = true;
            size++;
        }
        if (key != null) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null || keys[i] != null && keys[i].equals(key)) {
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
