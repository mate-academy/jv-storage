package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private K[] key;
    private V[] value;
    private int storageSize;

    public StorageImpl() {
        key = (K[]) new Object[MAX_LENGTH];
        value = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (compare(this.key[i], key)) {
                this.value[i] = value;
                return;
            }
        }
        if (isStorageFull()) {
            throw new RuntimeException("Storage is full! Can't add key: "
                    + key + ", value: " + value);
        }
        this.key[storageSize] = key;
        this.value[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (compare(this.key[i], key)) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    private boolean isStorageFull() {
        return storageSize == MAX_LENGTH;
    }

    private boolean compare(K key1, K key2) {
        return obj1 == obj2 || obj1 != null && obj1.equals(obj2);
    }
}
