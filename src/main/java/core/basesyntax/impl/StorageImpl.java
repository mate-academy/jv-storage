package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int MAX_WIDTH_NUMBER = 2;
    private Object [][] storage;

    public StorageImpl() {
        storage = new Object[MAX_WIDTH_NUMBER][MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        boolean haveEquals = false;
        for (int i = 0; i < storage.length; i++) {
            if (key == null && storage[0][i] == null) {
                storage[1][i] = value;
                haveEquals = true;
                break;
            } else if (key == null && storage != null) {
                continue;
            } else if (key.equals(storage[0][i])) {
                storage[1][i] = value;
                haveEquals = true;
                break;
            }
        }
        if (!haveEquals) {
            for (int i = 0; i < storage[0].length; i++) {
                if (storage[0][i] == null && storage[1][i] == null) {
                    storage[0][i] = key;
                    storage[1][i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage[0].length; i++) {
            if (key == null && storage[0][i] == null) {
                return (V) (storage[1][i]);
            } else if (key == null && storage != null) {
                continue;
            } else if (key.equals(storage[0][i])) {
                return (V) (storage[1][i]);
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < storage[1].length; i++) {
            if (storage[0][i] == null && storage[1][i] == null) {
                return i;
            }
        }
        return 0;
    }
}
