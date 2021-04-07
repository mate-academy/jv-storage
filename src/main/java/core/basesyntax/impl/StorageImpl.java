package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int sizeOfStorage = 0;
    private K[] key;
    private V[] value;

    public StorageImpl() {
        this.key = (K[])new Object[MAX_SIZE];
        this.value = (V[])new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (sizeOfStorage >= MAX_SIZE) {
            System.out.println("Can't add new value, array is full!");
        } else {
            for (int i = 0; i < sizeOfStorage; i++) {
                if (this.key[i] == key
                        || (key != null && key.equals(this.key[i]))) {
                    this.value[i] = value;
                    return;
                }
            }
            this.key[sizeOfStorage] = key;
            this.value[sizeOfStorage] = value;
            sizeOfStorage++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (this.key[i] == key || (key != null && key.equals(this.key[i]))) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }
}
