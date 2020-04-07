package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final byte arrayLength = 10;
    private static int i = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[arrayLength];
        values = (V[]) new Object[arrayLength];
    }

    @Override
    public void put(K key, V value) {
        for (int j = 0; j < i; j++) {
            if ((key == keys[j]) || (keys[j] != null && keys[j].equals(key))) {
                values[j] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        i++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < i; j++) {
            if ((key == keys[j]) || (keys[j] != null && keys[j].equals(key))) {
                return values[j];
            }
        }
        return null;
    }
}
