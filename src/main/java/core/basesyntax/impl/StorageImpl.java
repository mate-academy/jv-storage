package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private int size = 0;

    private Pair[] data = new Pair[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int j = 0; j < size(); j++) {
            if (data[j].getKey() != null && data[j].getKey().equals(key)
                    || data[j].getKey() == key) {
                data[j] = new Pair(key, value);
                return;
            }
        }

        Pair newPair = new Pair(key, value);
        data[size] = newPair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if ((data[i].getKey() == key || key != null && key.equals(data[i].getKey()))) {
                return (V) data[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
