package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int keyValueCounter;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        keyValueCounter = 0;
    }

    @Override
    public void put(K key, V value) {
        int index;
        if ((index = getKeyIndex(key, keys)) != -1) {
            values[index] = value;
        } else {
            keys[keyValueCounter] = key;
            values[keyValueCounter] = value;
            keyValueCounter++;
        }
    }

    private int getKeyIndex(K key, K[] keys) {
        for (int i = 0; i < keyValueCounter; i++) {
            if (safeObjCompare(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index;
        if ((index = getKeyIndex(key, keys)) != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return keyValueCounter;
    }

    private boolean safeObjCompare(Object a, Object b) {
        return (a == null ? b == null : a.equals(b));
    }
}
