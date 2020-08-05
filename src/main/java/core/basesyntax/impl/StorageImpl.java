package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;
    private K[] key;
    private V[] value;
    private int iterator;

    public StorageImpl() {
        key = (K[]) new Object[SIZE];
        value = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < iterator; i++) {
            if (((this.key[i] != null) && this.key[i].equals(key))
                    || (key == null && this.key[i] == null)) {
                this.value[i] = value;
                return;
            }
        }
        this.key[iterator] = key;
        this.value[iterator] = value;
        ++iterator;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < iterator; i++) {
            if (((this.key[i] != null) && this.key[i].equals(key))
                    || (key == null && this.key[i] == null)) {
                return this.value[i];
            }
        }
        return null;
    }
}
