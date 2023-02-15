package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STARTING_ARRAY_LENGTH = 10;
    private K[] keys = (K[]) new Object[STARTING_ARRAY_LENGTH];
    private V[] values = (V[]) new Object[STARTING_ARRAY_LENGTH];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int keyIndex = keyIndex(key);
        if (keyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keyIndex] = value;
        }
        if (keys.length == size) {
            increaseStorage();
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = keyIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    //returns -1 if no such key was found
    private int keyIndex(K obj) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(obj)) {
                return i;
            }
            if (keys[i] == null && obj == null) {
                return i;
            }
        }
        return -1;
    }

    //doubles arrays length
    private void increaseStorage() {
        K[] newKeysArray = (K[]) new Object[keys.length * 2];
        System.arraycopy(keys, 0, newKeysArray, 0, keys.length);
        keys = newKeysArray;

        V[] newValuesArray = (V[]) new Object[values.length * 2];
        System.arraycopy(values, 0, newValuesArray, 0, values.length);
        values = newValuesArray;
    }
}
