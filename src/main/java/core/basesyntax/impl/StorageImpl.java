package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private int sizeStorage = 0;
    private K[] keys = (K[]) new Object[MAX_SIZE_STORAGE];
    private V[] values = (V[]) new Object[MAX_SIZE_STORAGE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeStorage; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[sizeStorage] = key;
        values[sizeStorage] = value;
        sizeStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeStorage; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.sizeStorage;
    }
}
