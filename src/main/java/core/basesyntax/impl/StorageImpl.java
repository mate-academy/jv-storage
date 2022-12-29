package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_SIZE];
        valueStorage = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEquals(keyStorage[i], key)) {
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
            if (isEquals(keyStorage[i], key)) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEquals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
