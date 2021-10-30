package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_SIZE = 10;
    private Object[] key;
    private Object[] value;
    private int size;

    public StorageImpl() {
        this.key = new Object[MAX_STORAGE_SIZE];
        this.value = new Object[MAX_STORAGE_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
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
                return (V) value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
