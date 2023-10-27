package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private K[] keys = (K[]) new Object[MAX_ELEMENTS];
    private V[] values = (V[]) new Object[MAX_ELEMENTS];
    private int size = 0;

    private K[] nullKeys = (K[]) new Object[MAX_ELEMENTS];
    private V[] nullValues = (V[]) new Object[MAX_ELEMENTS];
    private int nullSize = 0;

    @Override
    public void put(K key, V value) {
        boolean found = false;
        if (key == null) {
            for (int i = 0; i < nullSize; i++) {
                if (nullKeys[i] == null) {
                    nullValues[i] = value;
                    found = true;
                    break;
                }
            }

            if (!found && nullSize < MAX_ELEMENTS) {
                nullKeys[nullSize] = key;
                nullValues[nullSize] = value;
                nullSize++;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    found = true;
                    break;
                }
            }

            if (!found && size < MAX_ELEMENTS) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        V res = null;
        if (key != null) {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    res = values[i];
                }
            }
        } else {
            for (int i = 0; i < nullSize; i++) {
                if (nullKeys[i] == null) {
                    res = nullValues[i];
                }
            }
        }
        return res;
    }

    @Override
    public int size() {
        return size + nullSize;
    }
}


