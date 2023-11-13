package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private final static int DEFAULT_SIZE = 10;
    private final static int RESIZE_COEFFICIENT = 2;
    private int size;


    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_SIZE];
        values = (V[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size < keys.length) {
            int index = findValueIndex(key);
            if (index == -1) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                keys[index] = key;
                values[index] = value;
            }
        } else {
            resize();
            put(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = findValueIndex(key);
        if (index == -1) {
            return null;
        } else {
            return values[index];
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int findValueIndex(K key) {
        if (key == null) {
            int index = -1;
            for (int i = 0; i < size; ++i) {
                if (keys[i] == null) {
                    index = i;
                    return index;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (key == keys[i] | key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    //Growing array may be not mandatory, but I still think it's needed here.
    private void resize() {
        K[] newKeysArray = (K[])(new Object[keys.length * RESIZE_COEFFICIENT]);
        V[] newValuesArray = (V[])(new Object[keys.length * RESIZE_COEFFICIENT]);
        System.arraycopy(keys, 0, newKeysArray, 0, keys.length);
        System.arraycopy(values, 0, newValuesArray, 0, values.length);
        keys = newKeysArray;
        values = newValuesArray;
    }
}
