package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_CAPACITY];
        valueStorage = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areBothKeysNull(key, keyStorage[i]) || key != null && key.equals(keyStorage[i])) {
                valueStorage[i] = value;
                return;
            }
        }
        if (size > 10) {
            return;
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areBothKeysNull(key, keyStorage[i]) || key != null && key.equals(keyStorage[i])) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areBothKeysNull(K key, K existingKey) {
        return key == null && existingKey == null;
    }
}
