package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private K key;
    private V value;
    private int sizeStorage = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ELEMENTS];
        this.values = (V[]) new Object[MAX_ELEMENTS];
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeStorage; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (sizeStorage < MAX_ELEMENTS) {
            keys[sizeStorage] = key;
            values[sizeStorage] = value;
            sizeStorage++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeStorage; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return values[i];
                }
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeStorage;
    }
}
