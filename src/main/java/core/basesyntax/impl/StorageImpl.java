package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_RANGE_OF_ARRAY = 10;
    private int sizeStorage = 0;
    private final K[] keysOfStorage;
    private final V[] valuesOfStorage;

    public StorageImpl() {
        keysOfStorage = (K[]) new Object[MAX_RANGE_OF_ARRAY];
        valuesOfStorage = (V[]) new Object[MAX_RANGE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeStorage; i++) {
            if (key == keysOfStorage[i] || key != null && key.equals(keysOfStorage[i])) {
                valuesOfStorage[i] = value;
                return;
            }
        }
        keysOfStorage[sizeStorage] = key;
        valuesOfStorage[sizeStorage] = value;
        sizeStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeStorage; i++) {
            if (key == keysOfStorage[i] || key != null && key.equals(keysOfStorage[i])) {
                return valuesOfStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeStorage;
    }
}
