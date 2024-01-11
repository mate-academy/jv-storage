package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int INITIALIZATION_SIZE = 0;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
        this.size = INITIALIZATION_SIZE;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            K keyInArray = keys[i];
            if (key == keyInArray || keyInArray != null && keyInArray.equals(key)) {
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
            K keyInArray = keys[i];
            if (key == keyInArray || keyInArray != null && keyInArray.equals(key)) {
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
