package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private Pair[] data = new Pair[DEFAULT_CAPACITY];

    @Override
    public void put(K key, V value) {
        Pair newPair = new Pair(key, value);
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = newPair;
                break;
            }

            if (data[i] != null) {
                if (data[i].getKey() == null && newPair.getKey() == null) {
                    data[i] = newPair;
                    break;
                }

                if (data[i].getKey() != null && data[i].getKey().equals(newPair.getKey())) {
                    data[i] = newPair;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (key != null) {
            for (Pair pair : data) {
                if (pair != null && pair.getKey() != null) {
                    if (pair.getKey().equals(key)) {
                        return (V) pair.getValue();
                    }
                }
            }
        }

        if (key == null) {
            for (Pair pair : data) {
                if (pair != null) {
                    if (pair.getKey() == null) {
                        return (V) pair.getValue();
                    }

                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int j = 0; j < data.length; j++) {
            if (data[j] != null) {
                size++;
            }
        }

        return size;
    }
}
