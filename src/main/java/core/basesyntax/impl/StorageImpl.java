package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static int size;
    private Object[][] box;

    public StorageImpl() {
        box = new Object[2][MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (box[0][i] == key
                    || box[0][i] != null && box[0][i].equals(key)) {
                box[1][i] = value;
                return;
            }
        }
        box[0][size] = key;
        box[1][size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (box[0][i] == key
                    || box[0][i] != null && box[0][i].equals(key)) {
                return (V) box[1][i];
            }
        }
        return null;
    }

}
