package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_OF_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        Integer index = indexOf(key);
        if (index != null) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        Integer index = indexOf(key);
        return index != null ? values[index] : null;

    }

    private boolean keysAreEquals(K first, K second) {
        return (first == second) || (second != null && second.equals(first));
    }

    private Integer indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keysAreEquals(key, keys[i])) {
                return i;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
