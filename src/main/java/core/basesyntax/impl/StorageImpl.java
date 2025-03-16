package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keysOfStorage;
    private final V[] valuesOfStorage;
    private int sizeOfStorage;

    public StorageImpl() {
        this.keysOfStorage = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.valuesOfStorage = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfStorage; i++) {
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
