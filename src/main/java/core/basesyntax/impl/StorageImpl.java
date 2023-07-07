package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;
    private Pair<K, V>[] storage;
    private int indexOfNextPair = 0;

    public StorageImpl() {
        storage = new Pair[ARRAY_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        int indexOfPair = getIndexOfPair(pair);
        if (indexOfPair != -1) {
            storage[indexOfPair] = pair;
        } else {
            storage[indexOfNextPair] = new Pair<>(key, value);
            indexOfNextPair++;
        }
    }

    @Override
    public V get(K key) {
        if (indexOfNextPair == 0) {
            return null;
        }
        for (int i = 0; i < size(); i++) {
            if (storage[i].getKey() == null && key == null) {
                return storage[i].getValue();
            } else if (storage[i].getKey() != null && storage[i].getKey().equals(key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return indexOfNextPair;
    }

    private int getIndexOfPair(Pair<K,V> pair) {
        for (int i = 0; i < size(); i++) {
            if ((pair.getKey() == null && storage[i].getKey() == null)
                    || storage[i].getKey() != null && storage[i].getKey().equals(pair.getKey())) {
                return i;
            }
        }
        return -1;
    }
}
