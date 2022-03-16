package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_CAPACITY = 20;
    private Object[] array;

    public StorageImpl() {
        this.array = new Object[0];
    }

    @Override
    public void put(K key, V value) {
        boolean isPresent = false;
        if (array.length == 0) {
            array = new Object[array.length + 2];
            array[0] = key;
            array[1] = value;
        }
        for (int i = 0; i < array.length; i = i + 2) {
            if (array[i] == key || array[i] != null && array[i].equals(key)) {
                array[i + 1] = value;
                isPresent = true;
            }
        }
        if (!isPresent) {
            if (array.length < MAX_CAPACITY) {
                Object[] newArray;
                newArray = array;
                array = new Object[array.length + 2];
                System.arraycopy(newArray, 0, array, 0, newArray.length);
                array[array.length - 2] = key;
                array[array.length - 1] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < array.length; i = i + 2) {
            if (array[i] == key || array[i] != null && array[i].equals(key)) {
                return (V) array[i + 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return array.length / 2;
    }
}
