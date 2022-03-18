package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Pair;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private static int index;
    private Pair[] storage;

    public StorageImpl() {
        this.storage = new Pair[SIZE_OF_ARRAY];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        int indexArray = getIndexArray(key);
        if (indexArray == -1) {
            storage[index] = new Pair(key, value);
            index++;
        } else {
            storage[indexArray] = new Pair(key, value);
        }
    }

    @Override
    public V get(K key) {
        int indexArray = getIndexArray(key);
        if (indexArray == -1) {
            return null;
        }
        return (V) storage[indexArray].getValue();
    }

    private int getIndexArray(K key) {
        for (int i = 0; i < index; i++) {
            if (storage[i].getKey() == key
                    || storage[i].getKey() != null
                    && storage[i].getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return index;
    }
}
