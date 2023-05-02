package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        key = (K[]) new Object[MAX_LENGTH];
        value = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (isStorageFull()) {
            throw new RuntimeException("Can not add key: "
                + key + ", value: " + value + ". Storage is full! ");
        }
        for (int i = 0; i < size; i++) {
            if (compare(this.key[i], key)) {
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
            if (compare(this.key[i], key)) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isStorageFull() {
        return size == MAX_LENGTH;
    }

    private boolean compare(K key1, K key2) {
        return Objects.equals(key1, key2);
    }
}
