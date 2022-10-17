package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    final byte MAX_SIZE = 10;
    private int size = 0;
    private Pair[] storage = new Pair[MAX_SIZE];
    @Override
    public void put(K key, V value) {
        Pair pair = new Pair(key, value);
        if (size() == MAX_SIZE) {
            throw new RuntimeException("Max size of storage is " + MAX_SIZE);
        }
        if (pair.getValue() == null) {
            return;
        }
        if (getIndex(key) >= 0) {
            int i = getIndex(key);
            storage[i] = pair;
        } else {
            storage[size++] = pair;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].getKey() != null && storage[i].getKey().equals(key)
                    || storage[i].getKey() == key && key == null) {
                return (V) storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((storage[i].getKey() != null) && storage[i].getKey().equals(key)
                    || (storage[i].getKey() == null) && (key == null)) {
                return i;
            }
        }
        return -1;
    }
}
