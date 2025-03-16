package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int currentCapacity;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        currentCapacity = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentCapacity; i++) {
            if (isKeysEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[currentCapacity] = key;
        values[currentCapacity] = value;
        currentCapacity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentCapacity; i++) {
            if (isKeysEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentCapacity;
    }

    public boolean isKeysEqual(K firstKey, K secondKey) {
        return (firstKey == secondKey) || (firstKey != null && firstKey.equals(secondKey));
    }
}
