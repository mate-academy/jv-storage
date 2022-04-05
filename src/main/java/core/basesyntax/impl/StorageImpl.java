package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[][] data = new Object[10][2];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (data[i][0] == key || data[i][0] != null && data[i][0].equals(key)) {
                data[i][1] = value;
                return;
            }
        }
        data[size][0] = key;
        data[size][1] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < size; j++) {
            if (data[j][0] == key || data[j][0] != null && data[j][0].equals(key)) {
                return (V) data[j][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
