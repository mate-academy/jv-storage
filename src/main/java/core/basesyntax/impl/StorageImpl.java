package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final K[] key;
    private final V[] value;

    public StorageImpl() {
        this.value = (V[]) new Object[ARRAY_SIZE];
        this.key = (K[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (this.key[i] != null && this.key[i].equals(key)) {
                this.value[i] = value;
                break;
            }
            if (this.key[i] == null && key == null) {
                this.value[i] = value;
                break;
            }
            if (this.key[i] == null && this.value[i] == null) {
                this.key[i] = key;
                this.value[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if ((this.key[i] != null && this.key[i].equals(key))
                    || (this.key[i] == null && key == null)) {
                return value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (V v : this.value) {
            if (v != null) {
                counter++;
            }
        }
        return counter;
    }
}
