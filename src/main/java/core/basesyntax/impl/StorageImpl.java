package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private final K[] key;
    private final V[] value;
    private int size;

    public StorageImpl() {
        key = (K[]) new Object[MAX_SIZE_STORAGE];
        value = (V[]) new Object[MAX_SIZE_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((this.key[i] == key)
                    || (this.key[i] != null && this.key[i].equals(key))) {
                this.value[i] = value;
                return;
            }
        }
        this.key[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((this.key[i] == key)
                    || (this.key[i] != null && this.key[i].equals(key))) {
                return value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
