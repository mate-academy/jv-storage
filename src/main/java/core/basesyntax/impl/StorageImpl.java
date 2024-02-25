package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private final K[] keyArray;
    private final V[] valueArray;

    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_SIZE];
        valueArray = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == -1) {
            add(key, value);
        } else {
            replace(value, index);
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1
                ? null
                : valueArray[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void replace(V value, int index) {
        valueArray[index] = value;
    }

    private void add(K key, V value) {
        if (size == MAX_SIZE) {
            throw new IllegalArgumentException();
        }

        valueArray[size] = value;
        keyArray[size] = key;
        size++;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEquals(key, keyArray[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean areKeysEquals(K key, K otherKey) {
        return ((otherKey == null && key == null)
                || (otherKey != null && otherKey.equals(key)));
    }
}
