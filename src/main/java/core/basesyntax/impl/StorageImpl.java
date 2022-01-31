package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_SIZE = 10;
    private final K[] key;
    private final V[] value;
    private int size;

    public StorageImpl() {
        key = (K[]) new Object[MAXIMUM_SIZE];
        value = (V[]) new Object[MAXIMUM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            this.value[size - 1] = value;
        } else {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(this.key[i]) || (this.key[i] == key)) {
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
