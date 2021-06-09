package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private int lengthArray = 0;
    private K[] key;
    private V[] value;

    public StorageImpl() {
        key = (K[]) new Object[MAX_SIZE_ARRAY];
        value = (V[]) new Object[MAX_SIZE_ARRAY];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < lengthArray; i++) {
            if (this.key[i] == key || (key != null && key.equals(this.key[i]))) {
                this.value[i] = value;
                return;
            }
        }
        this.key[lengthArray] = key;
        this.value[lengthArray] = value;
        lengthArray++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lengthArray; i++) {
            if (this.key[i] == key || (key != null && key.equals(this.key[i]))) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lengthArray;
    }
}
