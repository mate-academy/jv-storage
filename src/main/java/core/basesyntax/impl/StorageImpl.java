package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_ELEMENTS = 10;
    private final Object[][] storage;
    private int size;

    public StorageImpl() {
        this.storage = new Object[MAX_NUMBER_ELEMENTS][2];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if (key == null && storage[i][0] == null || key != null && key.equals(storage[i][0])
                    || storage[i][0] == null && storage[i][1] == null) {
                storage[i][0] = key;
                storage[i][1] = value;
                return;
            }
        }
        storage[size()][0] = key;
        storage[size()][1] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == null && storage[i][0] == null || key != null && key.equals(storage[i][0])) {
                return (V) storage[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
