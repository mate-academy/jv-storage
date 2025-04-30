package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_ELEMENTS];
        this.values = (V[]) new Object[MAX_STORAGE_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_ELEMENTS; i++) {
            if (keys[i] == key || keys[i] == null && values[i] == null) {
                keys[i] = key;
                if (values[i] == null) {
                    size++;
                }
                values[i] = value;
                return;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_STORAGE_ELEMENTS; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }

        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
