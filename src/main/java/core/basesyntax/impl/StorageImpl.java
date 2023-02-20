package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_LENGTH = 10;
    private final K[] keysStorage;
    private final V[] valuesStorage;
    private int length;

    public StorageImpl() {
        keysStorage = (K[]) new Object[ARRAY_MAX_LENGTH];
        valuesStorage = (V[]) new Object[ARRAY_MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < length; i++) {
            if (keysStorage[i] == key || keysStorage[i] != null && keysStorage[i].equals(key)) {
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
            if (keysStorage[i] == key || keysStorage[i] != null && keysStorage[i].equals(key)) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return length;
    }
}

