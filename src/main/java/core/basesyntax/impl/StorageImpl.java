package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        key = (K[]) new Object[STORAGE_SIZE];
        value = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        } else {
            this.value[size - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
