package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MaxStorageSize = 10;
    private K[] keys;
    private V[] values;
    private int storageSize = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MaxStorageSize];
        values = (V[]) new Object[MaxStorageSize];
    }

    @Override
    public void put(K key, V value) {
        if (storageSize < MaxStorageSize) {
            for (int i = 0; i < storageSize; i++) {
                if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                    values[i] = value;
                    return;
                }
            }
            this.keys[storageSize] = key;
            this.values[storageSize] = value;
            storageSize++;
        } else {
            System.out.println("The limit of storage is 10");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof StorageImpl<?, ?>)) {
            return false;
        }
        StorageImpl<K, V> storage = (StorageImpl<K, V>) object;

        if (storageSize != storage.storageSize) {
            return false;
        }

        for (int i = 0; i < storageSize; i++) {
            if (keys[i] == null && storage.keys[i] != null || keys[i] != null
                    && !keys[i].equals(storage.keys[i])) {
                return false;
            }
            if (values[i] == null && storage.values[i] != null || values[i] != null
                    && !values[i].equals(storage.values[i])) {
                return false;
            }
        }

        return true;
    }
}


