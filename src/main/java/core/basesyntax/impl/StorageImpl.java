package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int count;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_ARRAY_LENGTH];
        valueStorage = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == keyStorage[i]
                    || key != null && key.equals(keyStorage[i])) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[count] = key;
        valueStorage[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == keyStorage[i]
                    || key != null && key.equals(keyStorage[i])) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
