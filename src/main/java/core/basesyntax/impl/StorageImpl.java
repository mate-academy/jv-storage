package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private K[] arrayKeys = (K[]) new Object [MAX_NUMBER];
    private V [] arrayValues = (V[]) new Object [MAX_NUMBER];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrayKeys[i] || key != null && key.equals(arrayKeys[i])) {
                arrayValues[i] = value;
                return;
            }
        }
        arrayKeys[size] = key;
        arrayValues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if (arrayKeys[i] == key || arrayKeys[i] != null && arrayKeys[i].equals(key)) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
