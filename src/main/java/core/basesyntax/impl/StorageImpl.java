package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[0];
        values = (V[]) new Object[0];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex == -1) {
            keys = increaseArraySizeByOne(keys);
            values = increaseArraySizeByOne(values);
            keyIndex = keys.length - 1;
        }
        keys[keyIndex] = key;
        values[keyIndex] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.length;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private <T> T[] increaseArraySizeByOne(T[] array) {
        T[] newArray = (T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}
