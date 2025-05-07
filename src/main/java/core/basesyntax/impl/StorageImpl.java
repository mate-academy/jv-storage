package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int BOUNDED_ARRAY_SIZE = 10;
    private final K[] keysStorage;
    private final V[] valuesStorage;
    private int storageSize;

    public StorageImpl() {
        keysStorage = (K[]) new Object[BOUNDED_ARRAY_SIZE];
        valuesStorage = (V[]) new Object[BOUNDED_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (keysStorage[i] == key || (keysStorage[i] != null && keysStorage[i].equals(key))) {
                valuesStorage[i] = value;
                return;
            }
        }
        if (storageSize >= BOUNDED_ARRAY_SIZE) {
            throw new RuntimeException("You have exceeded the limit");
        }
        keysStorage[storageSize] = key;
        valuesStorage[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (key != null && key.equals(keysStorage[i]) || key == keysStorage[i]) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
