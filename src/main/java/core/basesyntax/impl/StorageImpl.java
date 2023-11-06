package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int DEFAULT_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_ITEMS_NUMBER];
        values = (V[]) new Object[DEFAULT_ITEMS_NUMBER];
    }

    private boolean isSame(K key, int i) {
        return keys[i] == key || keys[i] != null && keys[i].equals(key);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isSame(key, i)) {
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
        for (int i = 0; i < size; i++) {
            if (isSame(key, i)) {
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
