package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys;
    private final V[] values;
    private final int maxSize = 10;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[maxSize];
        this.values = (V[]) new Object[maxSize];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            boolean isMatch = (key == null) ? (keys[i] == null) : key.equals(keys[i]);
            if (isMatch) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
