package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final Object[] indexes;
    private final Object[] values;

    private int storageCapacity = 0;

    public StorageImpl() {
        indexes = new Object[MAX_STORAGE_CAPACITY];
        values = new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageCapacity; i++) {
            K item = (K) indexes[i];
            if (key == item || (item != null && item.equals(key))) {
                this.values[i] = value;
                return;
            }
        }
        indexes[storageCapacity] = key;
        values[storageCapacity] = value;
        storageCapacity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageCapacity; i++) {
            if (key == indexes[i] || (indexes[i] != null && indexes[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageCapacity;
    }
}
