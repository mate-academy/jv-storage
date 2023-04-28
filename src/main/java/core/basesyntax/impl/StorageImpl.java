package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMNTS_IN_STORAGE = 10;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_ELEMNTS_IN_STORAGE];
        this.value = (V[]) new Object[MAX_ELEMNTS_IN_STORAGE];
        this.size = 0;
    }


    @Override
    public void put(K key, V value) {
        int index = indexElement(key);
        if (index >= 0) {
            this.value[index] = value;
        } else {
            if (size == this.key.length) {
                throw new IllegalStateException("Storage is full");
            }
            this.key[size] = key;
            this.value[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexElement(key);
        if (index >= 0) {
            return value[index];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int indexElement(K key) {
        for (int i = 0; i < size; i++) {
            if (this.key[i] != null && this.key[i].equals(key)) {
                return i;
            } else if (key == null && this.key[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
