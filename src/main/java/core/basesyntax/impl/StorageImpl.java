package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_OF_ARRAY = 10;
    private int size;
    private K[] key;
    private V[] value;

    public StorageImpl() {
        size = 0;
        key = (K[]) new Object[MAX_LENGTH_OF_ARRAY];
        value = (V[]) new Object[MAX_LENGTH_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (get(key) != null) {
                this.key[i] = key;
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
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
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
