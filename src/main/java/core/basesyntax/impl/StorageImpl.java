package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private Object[] keyArray = new Object[10];
    private Object[] valueArray = new Object[10];

    public void put(K key, V value) {
        if (size == 0) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keyArray[i] == null) {
                    valueArray[i] = value;
                    return;
                }
            } else {
                if (key.equals((K) keyArray[i])) {
                    valueArray[i] = value;
                    return;
                }
            }
        }
        if (size == keyArray.length) {
            keyArray = Arrays.copyOf(keyArray, keyArray.length * 2);
            valueArray = Arrays.copyOf(valueArray, valueArray.length * 2);
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keyArray[i] == null) {
                    return (V) valueArray[i];
                }
            } else {
                if (key.equals((K) keyArray[i])) {
                    return (V) valueArray[i];
                }
            }
        }
        return null;
    }
}

