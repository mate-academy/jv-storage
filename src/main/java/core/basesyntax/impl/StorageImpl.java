package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int size;

    public StorageImpl() {
        this.keyStorage = (K[]) new Object[MAX_SIZE_ARRAY];
        this.valueStorage = (V[]) new Object[MAX_SIZE_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || key != null && (key.equals(keyStorage[i]))) {
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || (key != null && key.equals(keyStorage[i]))) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
