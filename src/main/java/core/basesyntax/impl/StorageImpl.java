package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private Pair<K, V>[] store;
    private int size;

    public StorageImpl() {
        store = new Pair[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int position = getPosition(key);
        store[position] = new Pair<>(key, value);
        if (position == size) {
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeyEquals((K) store[i].getKey(), key)) {
                return (V) store[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areKeyEquals(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    private int getPosition(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeyEquals(store[i].getKey(), key)) {
                return i;
            }
        }
        return size;
    }
}
