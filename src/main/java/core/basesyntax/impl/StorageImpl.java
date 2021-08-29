package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private int index = 0;
    private K[] keys = (K[]) new Object[MAX_ITEMS];
    private V[] values = (V[]) new Object[MAX_ITEMS];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (checkIfEqual(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        values[index] = value;
        keys[index] = key;
        index++;
    }

    @Override
    public V get(K key) {
        int localIndex = 0;
        for (K localKey : keys) {
            if (checkIfEqual(key, localKey)) {
                return values[localIndex];
            }
            localIndex++;
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }

    private boolean checkIfEqual(K newKey, K localKey) {
        return (localKey == newKey || localKey != null && localKey.equals(newKey));
    }
}
