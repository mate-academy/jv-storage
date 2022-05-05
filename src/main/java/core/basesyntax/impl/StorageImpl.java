package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS_NUMBER = 10;
    private final K[] keys = (K[]) new Object[MAX_PAIRS_NUMBER];
    private final V[] values = (V[]) new Object[MAX_PAIRS_NUMBER];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == keys || ((keys[i] == key) || (keys[i] != null && keys[i].equals(key)))
                    && values[i] != null) {
                values[i] = value;
                size--;
            }
        }
        this.keys[size] = key;
        this.values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || ((keys[i] == key) || (keys[i] != null && keys[i].equals(key)))) {
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
