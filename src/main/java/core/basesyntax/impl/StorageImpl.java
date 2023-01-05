package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_NUMBERS_OF_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBERS_OF_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBERS_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareElement(key, keys[i])) {
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
            if (compareElement(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareElement(K key, K currentKey) {
        return key == currentKey || (key != null && key.equals(currentKey));
    }
}
