package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.security.Key;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int length = 10;
    Object[] keys = new Object[length];
    Object[] values = new Object[length];

    private int count = 0;
    @Override
    public void put(K key, V value) {
       keys[count] = key;
       values[count] = value;
       count++;


    }

    @Override
    public V get(K key) {

        Object[] keys1 = new Object[count];
        Object[] values1 = new Object[count];
        V keyNull = null;
        for (int i = 0; i < keys1.length; i++) {
            keys1[i] = keys[i];
            values1[i] = values[i];

        }
        for (int i = 0; i < keys1.length; i++) {
            if (keys1[i] == null) {
                keyNull = (V) values1[i];
            }
        }
        V value = null;

        for (int i = 0; i < keys1.length; i++) {
            if (keys1[i] == null && key == null) {
                value = keyNull;
            } else if (keys1[i] != null && keys1[i].equals(key)) {
                value = (V) values1[i];
            }
        }
        return value;
    }

    @Override
    public int size() {

        return count;
    }
}
