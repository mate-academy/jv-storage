package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    @SuppressWarnings("unchecked")
    private final K[] keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    @SuppressWarnings("unchecked")
    private final V[] values = (V[]) new Object[MAX_ITEMS_NUMBER];
    private int keyValueCounter;

    public StorageImpl() {
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

    private int getKeyIndex(K key, K[] keys) {
        for (int i = 0; i < keyValueCounter; i++) {
            if (safeObjCompare(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean safeObjCompare(Object a, Object b) {
        return (a == null ? b == null : a.equals(b));
    }
}
