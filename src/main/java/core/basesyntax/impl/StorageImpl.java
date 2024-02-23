package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int INCREASE_FACTOR = 2;

    private Object[] keys;
    private Object[] values;
    private int currentCapacity;
    private int currentSize;

    public StorageImpl() {
        keys = new Object[DEFAULT_CAPACITY];
        values = new Object[DEFAULT_CAPACITY];
        currentCapacity = DEFAULT_CAPACITY;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOfKey(key);
        if (index < 0) {
            addNew(key, value);
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexOfKey(key);
        if (index >= 0) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int getIndexOfKey(K key) {
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            if ((key == null && keys[i] == key)
                    || (key != null && key.equals(keys[i]))) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void addNew(K key, V value) {
        if (currentSize >= currentCapacity) {
            increaseCapacity();
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    private void increaseCapacity() {
        Object[] keysTemp = keys;
        Object[] valuesTemp = values;

        currentCapacity *= INCREASE_FACTOR;

        keys = new Object[currentCapacity];
        values = new Object[currentCapacity];

        for (int i = 0; i < currentSize; i++) {
            keys[i] = keysTemp[i];
            values[i] = valuesTemp[i];
        }
    }
}
