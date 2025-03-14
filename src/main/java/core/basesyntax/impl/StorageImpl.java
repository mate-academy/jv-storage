package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] key;
    private V[] value;
    private int size = 0;

    public StorageImpl() {
        key = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        value = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (this.key[i] == key
                    || (this.key[i] != null
                    && key != null
                    && this.key[i].equals(key))) {
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
            if (this.key[i] == key
                    || (this.key[i] != null
                    && key != null
                    && this.key[i].equals(key))) {
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
