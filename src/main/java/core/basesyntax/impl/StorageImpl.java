package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Pair<K, V>[] storage;
    private int size = 0;

    public StorageImpl() {
        storage = (Pair<K, V>[]) new Pair<?, ?>[STORAGE_SIZE];
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index == -1 ? null : storage[index].getValue();
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);

        if (index != -1) {
            storage[index].setValue(value);
            return;
        }

        for (int i = 0; i < STORAGE_SIZE; ++i) {
            if (storage[i] == null) {
                storage[i] = new Pair(key, value);
                ++size;
                return;
            }
        }
    }

    private int findIndex(K key) {
        for (int i = 0; i < STORAGE_SIZE; ++i) {
            if (storage[i] != null) {
                if ((storage[i].getKey() == null && key == null)
                        || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
