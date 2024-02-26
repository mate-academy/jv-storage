package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    private int size = 0;

    public StorageImpl() {
        keyArray = (K[]) new Object[CAPACITY];
        valueArray = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeyMatch(key, i)) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeyMatch(key, i)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyMatch(K key, int i) {
        return key == keyArray[i] || keyArray[i] != null && keyArray[i].equals(key);
    }
}
