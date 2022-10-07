package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int START_SIZE = 0;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_SIZE];
        this.value = (V[]) new Object[MAX_SIZE];
        this.size = START_SIZE;
    }

    @Override
    public void put(K key, V value) {
        if (this.size == 0 || get(key) == null) {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        } else {
            this.value[this.indexOf(get(key))] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.size + 1; i++) {
            if (key == null && this.key[i] == null) {
                return this.value[i];
            }
            if (this.key[i] != null && this.key[i].equals(key)) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int indexOf(V value) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.value[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }
}
