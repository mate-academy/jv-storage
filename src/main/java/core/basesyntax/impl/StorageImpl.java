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

    private boolean isKeyEqual(K key, int i) {
        if (key != null && keys[i] != null) {
            return (keys[i].equals(key));
        }
        return (keys[i] == key);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_ELEMENTS; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                this.size += 1;
                break;
            }
            if (isKeyEqual(key,i)) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_STORAGE_ELEMENTS; i++) {
            if (isKeyEqual(key,i)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
