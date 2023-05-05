package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_LENGTH = 10;
    private K[] keysStore;
    private V[] valuesStore;
    private int length;

    public StorageImpl() {
        keysStore = (K[]) new Object[ARRAY_MAX_LENGTH];
        valuesStore = (V[]) new Object[ARRAY_MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < length; i++) {
            if (compareKeys(keysStore[i], key)) {
                valuesStore[i] = value;
                return;
            }
        }
        keysStore[length] = key;
        valuesStore[length] = value;
        length++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < length; i++) {
            if (compareKeys(keysStore[i], key)) {
                return valuesStore[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    private boolean compareKeys(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }
}
