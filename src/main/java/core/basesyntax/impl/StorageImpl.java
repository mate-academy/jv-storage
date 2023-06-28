package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private final K[] storageKeys = (K[]) new Object[MAX_SIZE_STORAGE];
    private final V[] storageValues = (V[]) new Object[MAX_SIZE_STORAGE];
    private int currentSizeStorage = 0;
    private boolean repeatCheck = false;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSizeStorage; i++) {
            if (key != null && key.equals(storageKeys[i])
                    || (key == null && storageKeys[i] == null)) {
                storageValues[i] = value;
                repeatCheck = true;
                currentSizeStorage--;
            }
        }
        if (!repeatCheck) {
            repeatCheck = false;
            storageKeys[currentSizeStorage] = key;
            storageValues[currentSizeStorage] = value;
        }
        currentSizeStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSizeStorage; i++) {
            if (key != null && key.equals(storageKeys[i])
                    || storageKeys[i] == key) {
                return storageValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSizeStorage;
    }
}
