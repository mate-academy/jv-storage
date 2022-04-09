package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Object[][] array = new Object[10][2];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (checkStorage(key, value)) {
            array[size][0] = key;
            array[size][1] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == array[i][0] || key != null && key.equals(array[i][0])) {
                return (V) array[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean checkStorage(K key, V value) {
        for (int i = 0; i < array.length; i++) {
            if (key == null && array[i][0] == null && array[i][1] != null) {
                array[i][1] = value;
                return false;
            }
            if (array[i][0] != null) {
                if (array[i][0].equals(key)) {
                    array[i][1] = value;
                    return false;
                }
            }
        }
        return true;
    }
}
