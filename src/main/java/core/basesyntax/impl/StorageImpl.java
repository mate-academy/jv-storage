package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Object[][] array = new Object[10][2];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (checkStorage(key, value)) {
            addNew(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && array[i][0] == null && array[i][1] != null) {
                return (V) array[i][1];
            }
            if (array[i][0] != null) {
                if (array[i][0].equals(key)) {
                    return (V) array[i][1];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void addNew(K key, V value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == null && array[i][1] == null) {
                array[i][0] = key;
                array[i][1] = value;
                size++;
                break;
            }
        }
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
