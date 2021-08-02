package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private int size = 0;

    private Pair[] data = new Pair[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        Pair newPair = new Pair(key, value);
        if (size == 0) {
            data[0] = newPair;
            size++;
        } else {
            boolean isSimilar = false;
            for (int j = 0; j < size(); j++) {
                if (data[j] != null && data[j].getKey() != null
                        && data[j].getKey().equals(newPair.getKey())
                        || data[j] != null
                        && (data[j].getKey() == null && newPair.getKey() == null)) {
                    data[j] = newPair;
                    isSimilar = true;
                }
            }

            if (!isSimilar) {
                data[size] = newPair;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {

            if ((data[i] != null && key != null)
                    && (data[i].getKey() != null)
                    && (data[i].getKey().equals(key))
                    || data[i] != null && (key == null && data[i].getKey() == null)) {

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
