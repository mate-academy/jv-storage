package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private K[] key;
    private V[] value;
    private int storageSpaceCounter;

    public StorageImpl() {
        this.key = (K[]) new Object[MAXIMUM_CAPACITY];
        this.value = (V[]) new Object[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < this.key.length; i++) {
            if (key != null && this.key[i] != null) {
                if (this.key[i].equals(key)) {
                    this.value[i] = value;
                    storageSpaceCounter--;
                }
            }
            if (this.key[i] == key && this.value[i] != null) {
                this.value[i] = value;
                break;
            }
            if (this.key[i] == null && this.value[i] == null) {
                this.key[i] = key;
                this.value[i] = value;
                storageSpaceCounter++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if (key != null && this.key[i] != null) {
                if (this.key[i].equals(key)) {
                    return value[i];
                }
            } else if (this.key[i] == key) {
                return value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSpaceCounter;
    }
}
