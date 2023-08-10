package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private Object[][] items = new Object[STORAGE_MAX_SIZE][2];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == items[i][0] || key != null && key.equals(items[i][0])) {
                items[i][1] = value;
                return;
            }
        }
        items[size][0] = key;
        items[size][1] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == items[i][0] || key != null && key.equals(items[i][0])) {
                return (V)items[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
