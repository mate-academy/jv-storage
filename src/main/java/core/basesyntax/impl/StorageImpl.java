package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_SIZE = 16;
    private Object[][] storage;
    private int currentSize;

    public StorageImpl() {
        storage = new Object[2][INITIAL_SIZE];
        currentSize = 0;
    }

    private void extendsSize() {
        Object[][] newArray = Arrays.copyOfRange(storage, 0, storage[0].length * 2);
        storage = newArray;
    }

    private void fillFirsElement(K key, V value) {
        storage[0][currentSize] = key;
        storage[1][currentSize] = value;
        currentSize++;
    }

    @Override
    public void put(K key, V value) {
        if (currentSize >= storage[0].length * 0.8) {
            extendsSize();
        }

        if (currentSize == 0) {
            fillFirsElement(key, value);
        } else {
            for (int index = 0; index < currentSize; index++) {
                if (key == storage[0][index]
                        || storage[0][index] != null && storage[0][index].equals(key)) {
                    storage[1][index] = value;
                }
            }
            fillFirsElement(key, value);
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (storage[0][i] == key || storage[0][i] != null && storage[0][i].equals(key)) {
                return (V) storage[1][i];
            }
        }
        return null;
    }
}
