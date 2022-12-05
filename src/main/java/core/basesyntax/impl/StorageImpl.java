package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] key;
    private final V[] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_SIZE];
        this.value = (V[]) new Object[MAX_SIZE];
    }

    private int getPosition(K key) {
        for (int i = 0; i < size; i++) {
            if ((this.key[i] == key) || (this.key[i] != null && this.key[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = getPosition(key);
        if (keyPosition == -1) {
            if (this.size < MAX_SIZE) {
                this.key[size] = key;
                this.value[size] = value;
                this.size++;
            } else {
                System.out.println("Storage is full!");
            }
        } else {
            this.value[keyPosition] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyPosition = getPosition(key);
        if (keyPosition == -1) {
            return null;
        }
        return this.value[keyPosition];
    }

    @Override
    public int size() {
        return this.size;
    }
}
