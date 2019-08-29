package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int count;
    private final int defaultCapacyty = 10;
    private K[] keys = (K[]) new Object[defaultCapacyty];
    private V[] values = (V[]) new Object[defaultCapacyty];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if ((key == null && keys[i] == null) || keys[i].equals(key)) {
                values[i] = value;
                continue;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if ((key == null && keys[i] == null) || keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}

