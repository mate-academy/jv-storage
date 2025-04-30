package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private final int maxSize = 10;
    private int size = 0;

    public StorageImpl(K[] keys, V[] values) {
        this.keys = (K[]) new Object[maxSize];
        this.values = (V[]) new Object[maxSize];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        if (size < maxSize) {
            keys[size] = key;
            values[size] = value;
            size++;

        }

        @Override
        public V get(K key) {
            return null;
        }

        @Override
        public int size () {
            return 0;
        }
    }
}
