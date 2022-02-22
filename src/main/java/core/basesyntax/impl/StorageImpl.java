package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_ARRAY_VALUE = 10;
    private K[] keys = (K[]) new Object[MAX_ARRAY_VALUE];
    private V[] values = (V[]) new Object[MAX_ARRAY_VALUE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        storageAdd(size, key, value);
    }

    @Override
    public V get(K key) {
        for (int k = 0; k < size; k++) {
            if ((key == null && keys[k] == null) || (key != null && key.equals(keys[k]))) {
                return values[k];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void storageAdd(int currentCell, K key, V value) {
        keys[currentCell] = key;
        values[currentCell] = value;
        size++;
    }
}
