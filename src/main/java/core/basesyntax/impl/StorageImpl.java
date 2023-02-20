package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final K[] keysStorage;
    private final V[] valuesStorage;
    private int length;

    public StorageImpl() {
        keysStorage = (K[]) new Object[MAX_ARRAY_SIZE];
        valuesStorage = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < length; i++) {
            if (checkKeys(key, keysStorage[i])) {
                valuesStorage[i] = value;
                return;
            }
        }
        keysStorage[length] = key;
        valuesStorage[length++] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < length; i++) {
            if (checkKeys(key, keysStorage[i])) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    private boolean checkKeys(K key, K keys) {
        return keys == key || (keys != null && keys.equals(key));
    }

    @Override
    public int size() {
        return length;
    }
}
