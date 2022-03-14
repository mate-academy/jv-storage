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
        if (get(key) == null) {
            storage[index] = new Pair(key, value);
            index++;
        } else {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i].getKey().equals(key)) {
                    storage[i] = new Pair(key, value);
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getKey().equals(key) && key != null) {
                return (V) storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
