package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STARTING_CAPACITY = 10;
    public static final int NOT_FOUND_INDEX = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STARTING_CAPACITY];
        values = (V[]) new Object[STARTING_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keyIndex] = value;
        }
        if (keys.length == size) {
            increaseCapacity();
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != NOT_FOUND_INDEX) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K obj) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(obj))
                    || (keys[i] == obj)) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }

    private void increaseCapacity() {
        K[] newKeysArray = (K[]) new Object[keys.length * 2];
        System.arraycopy(keys, 0, newKeysArray, 0, keys.length);
        keys = newKeysArray;

        V[] newValuesArray = (V[]) new Object[values.length * 2];
        System.arraycopy(values, 0, newValuesArray, 0, values.length);
        values = newValuesArray;
    }
}
