package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private int sizeStorage;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        sizeStorage = 0;
        keys = (K[]) new Object[MAX_SIZE_STORAGE];
        values = (V[]) new Object[MAX_SIZE_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeStorage; i++) {
            if ((key == keys[i]) || ((key != null) && key.equals(keys[i]))) {
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
            if ((key == keys[i]) || ((key != null) && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeStorage;
    }
}
