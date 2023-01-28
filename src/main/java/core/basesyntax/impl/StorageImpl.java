package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int numberOfAllKeys = 0;
    private K[] keys = (K[]) new Object[DEFAULT_CAPACITY];
    private V[] values = (V[]) new Object[DEFAULT_CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (isKeyRepeative(key, keys[i])) {
                values[i] = value;
                numberOfAllKeys++;
                return;
            }
        }
        keys[numberOfAllKeys] = key;
        values[numberOfAllKeys] = value;
        numberOfAllKeys++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (isKeyRepeative(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counterOfRepElemetns = 0;
        for (int i = 1; i <= numberOfAllKeys; i++) {
            if (isKeyRepeative(keys[i - 1], keys[i])) {
                counterOfRepElemetns++;
            }
        }
        return numberOfAllKeys - counterOfRepElemetns;
    }

    public boolean isKeyRepeative(K key, K key2) {
        if ((key == null) && (key2 == null)
                || ((key != null) && (key.equals(key2)))) {
            return true;
        }
        return false;
    }
}
