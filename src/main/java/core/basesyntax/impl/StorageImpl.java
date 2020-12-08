package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int DEFAULT_CAPACITY = 10;
    private V[] values = (V[]) new Object[DEFAULT_CAPACITY];
    private K[] keys = (K[]) new Object[DEFAULT_CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {

            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {

            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }

            if (keys[i] == null && key == null) {
                return values[i];
            }
        }
        return null;
    }
}
