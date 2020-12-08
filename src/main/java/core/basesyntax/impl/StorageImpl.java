package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private K[] key;
    private V[] value;

    public StorageImpl() {
        this.key = (K[]) new Object[STORAGE_CAPACITY];
        this.value = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if (this.key[i] == null && this.value[i] == null) {
                this.key[i] = key;
                this.value[i] = value;
                break;
            }
            if ((this.key[i] == key)
                    || (this.key[i] != null && this.key[i].equals(key))) {
                this.value[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if (key == null && this.key[i] == null) {
                return this.value[i];
            } else if (key != null && key.equals(this.key[i])) {
                return this.value[i];
            }
        }
        return null;
    }
}
