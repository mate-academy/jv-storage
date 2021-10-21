package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private Object[][] storage;
    private int size = 0;

    public StorageImpl() {
        storage = new Object[NUMBER_OF_ELEMENTS][2];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            if (key == null) {
                if (storage[i][0] == null) {
                    storage[i][0] = key;
                    storage[i][1] = value;
                    break;
                }
            } else if (key.equals(storage[i][0]) || storage[i][0] == null
                    && storage[i][1] == null) {
                storage[i][0] = key;
                storage[i][1] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            if (key == null) {
                if (storage[i][0] == null) {
                    return (V) storage[i][1];
                }
            } else if (key.equals(storage[i][0])) {
                return (V) storage[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            if (storage[i][1] == null) {
                break;
            }
            size++;
        }
        return size;
    }
}
