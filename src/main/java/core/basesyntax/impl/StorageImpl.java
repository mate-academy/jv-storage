package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int h = 5;
    private K key;
    private V value;
    private final Object[][] storage = new Object[2][10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size(); i++) {
            if (storage[0][i] != null && storage[0][i].equals(key)) {
                storage[1][i] = value;
                break;
            }
            if (storage[0][i] == null && storage[1][i] == null) {
                storage[0][i] = key;
                storage[1][i] = value;
                break;
            }
            if (key == null && value != null
                    && storage[0][i] == null && storage[1][i] != null
                    && !storage[1][i].equals(value)) {
                storage[0][i] = key;
                storage[1][i] = value;
                break;
            }
            if (key == null && value != null && storage[0][i] == null && storage[1][i] == null) {
                storage[1][i] = value;
                break;
            }

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size(); i++) {
            if (storage[0][i] != null && storage[0][i].equals(key)) {
                return (V) storage[1][i];
            }
            if (key == null && storage[0][i] == null && storage[1][i] != null) {
                return (V) storage[1][i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < h; i++) {
            if (storage[0][i] != null || storage[1][i] != null) {
                size++;
            }
        }
        return size;
    }
}
