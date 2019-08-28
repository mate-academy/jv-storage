package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int BASE_SIZE = 16;
    private static final double INCREASE_COEFFICIENT = 0.7d;
    private int arraySize;
    private int arrayCountElement;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        this.arraySize = BASE_SIZE;
        arrayCountElement = 0;
        this.keys = new Object[arraySize];
        this.values = new Object[arraySize];
    }

    private int indexOfElement(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (((key == null) && (keys[i] == null)) || key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        resize();
        if (indexOfElement(key) == -1) {
            keys[arrayCountElement] = key;
            values[arrayCountElement] = value;
            arrayCountElement++;
        } else {
            values[indexOfElement(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (indexOfElement(key) == -1) {
            return null;
        }
        return (V) values[indexOfElement(key)];
    }

    private void resize() {
        if (arrayCountElement < arraySize * INCREASE_COEFFICIENT) {
            arraySize = (int) (arraySize * 1 / INCREASE_COEFFICIENT);
            Object[] keysTemp = new Object[arraySize];
            Object[] valuesTemp = new Object[arraySize];
            for (int i = 0; i < arrayCountElement; i++) {
                keysTemp[i] = keys[i];
                valuesTemp[i] = values[i];
            }
            keys = keysTemp;
            values = valuesTemp;
        }
    }
}

