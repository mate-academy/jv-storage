package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private static final int MIN_SIZE = 0;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_LENGTH];
        this.value = (V[]) new Object[MAX_LENGTH];
        this.size = MIN_SIZE;
    }

    @Override
    public void put(K key, V value) {
        for (int i = MIN_SIZE; i < size; i++) {
            if ((key != null && key.equals(this.key[i])) || key == this.key[i]) {
                this.value[i] = value;
                return;
            }
        }
        if (size < MAX_LENGTH) {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = MIN_SIZE; i < size; i++) {
            if ((key != null && key.equals(this.key[i])) || key == this.key[i]) {
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
