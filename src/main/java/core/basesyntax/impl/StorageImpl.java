package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private final K[] keys = (K[]) new Object[MAX_SIZE_STORAGE];
    private final V[] values = (V[]) new Object[MAX_SIZE_STORAGE];
    private int currentSizeStorage = 0;
    private boolean repeatCheck = false;

    public boolean checkKeyInStorage(K key, V value) {
        for (int i = 0; i < currentSizeStorage; i++) {
            if (key != null && key.equals(keys[i])
                    || (key == null && keys[i] == null)) {
                values[i] = value;
                currentSizeStorage--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        if (!checkKeyInStorage(key, value)) {
            keys[currentSizeStorage] = key;
            values[currentSizeStorage] = value;
        }
        currentSizeStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSizeStorage; i++) {
            if (key != null && key.equals(keys[i])
                    || keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSizeStorage;
    }
}
