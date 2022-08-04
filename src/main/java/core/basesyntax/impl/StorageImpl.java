package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private K[] keysArray = (K[]) new Object[NUMBER_OF_ELEMENTS];
    private V[] valuesArray = (V[]) new Object[NUMBER_OF_ELEMENTS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (getValueIndexByKey(key) == -1) {
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
        } else {
            valuesArray[getValueIndexByKey(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return (getValueIndexByKey(key) == -1) ? null : (V) valuesArray[getValueIndexByKey(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getValueIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
