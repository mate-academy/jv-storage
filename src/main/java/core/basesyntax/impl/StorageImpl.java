package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    final static int MAX_LENGTH = 10;
    K[] keys = (K[]) new Object[MAX_LENGTH];
    V[] values = (V[]) new Object[MAX_LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (values[i] == null || keys[i] == key) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if(key == null) {
                if (keys[i] == key) {
                    return values[i];
                }
            } else {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        return null;
    }
}
