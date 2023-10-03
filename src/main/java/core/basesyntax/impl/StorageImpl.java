package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] key;
    private V[] value;
    private int index = 0;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_SIZE];
        this.value = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (findByKey(key) == -1) {
            this.key[index] = key;
            this.value[index] = value;
        } else {
            this.value[findByKey(key)] = value;
        }
        index++;
    }

    @Override
    public V get(K key) {
        if (findByKey(key) != -1) {
            return value[findByKey(key)];
        }

        return null;
    }

    @Override
    public int size() {
        int size = 0;

        for (V element : value) {
            if (element != null) {
                size++;
            }
        }

        return size;
    }

    private int findByKey(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
                return i;
            }
        }

        return -1;
    }
}
