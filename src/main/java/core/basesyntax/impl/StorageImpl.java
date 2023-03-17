package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int SIZE_OF_STORAGE = 10;
    private final K[] keysOfStorage;
    private final V[] valuesOfStorage;
    private int sizeOfStorage;

    public StorageImpl() {
        this.keysOfStorage = (K[]) new Object[SIZE_OF_STORAGE];
        this.valuesOfStorage = (V[]) new Object[SIZE_OF_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfStorage;i++) {
            if (key == keysOfStorage[i] || key != null && key.equals(keysOfStorage[i])) {
                valuesOfStorage[i] = value;
                return;
            }

        }
        keysOfStorage[sizeOfStorage] = key;
        valuesOfStorage[sizeOfStorage] = value;
        sizeOfStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (key == keysOfStorage[i] || key != null && key.equals(keysOfStorage[i])) {
                return valuesOfStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }
}
