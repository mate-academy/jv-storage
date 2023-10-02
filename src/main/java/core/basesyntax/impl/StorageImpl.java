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
        for (int i = 0; i < this.key.length; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
                this.key[i] = key;
                this.value[i] = value;
                index++;
                return;
            }
        }

        this.key[index] = key;
        this.value[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
                return this.value[i];
            }
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
}
