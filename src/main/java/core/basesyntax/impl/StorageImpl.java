package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int usedCapacity;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
        usedCapacity = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < usedCapacity; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[usedCapacity] = key;
        values[usedCapacity] = value;
        usedCapacity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < usedCapacity; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }
}
