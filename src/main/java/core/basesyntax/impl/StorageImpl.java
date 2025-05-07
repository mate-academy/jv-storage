package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int INCREASE_FACTOR = 2;
    private static final int NOT_FOUND = -1;

    private Object[] keys;
    private Object[] values;
    private int capacity;
    private int size;

    public StorageImpl() {
        keys = new Object[DEFAULT_CAPACITY];
        values = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
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
        if (index == NOT_FOUND) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOfKey(K key) {
        int index = NOT_FOUND;
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == key)
                    || (key != null && key.equals(keys[i]))) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void addNew(K key, V value) {
        if (size >= capacity) {
            increaseCapacity();
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    private void increaseCapacity() {
        Object[] keysTemp = keys;
        Object[] valuesTemp = values;

        capacity *= INCREASE_FACTOR;

        keys = new Object[capacity];
        values = new Object[capacity];

        for (int i = 0; i < size; i++) {
            keys[i] = keysTemp[i];
            values[i] = valuesTemp[i];
        }
    }
}
