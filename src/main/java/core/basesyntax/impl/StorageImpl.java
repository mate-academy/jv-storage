package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {

    private static final int ARRAYSIZE = 10;
    private Object[] keys = new Object[ARRAYSIZE];
    private Object[] values = new Object[ARRAYSIZE];
    private int topArray = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        if (topArray > keys.length - 1) {
            resizeAndCopyArr(keys);
            resizeAndCopyArr(values);
        }
        keys[topArray] = key;
        values[topArray] = value;
        topArray++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    private Object[] resizeAndCopyArr(Object[] input) {
        return Arrays.copyOf(input, input.length * 3 / 2);
    }
}
