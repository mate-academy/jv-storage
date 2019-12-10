package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int INITIAL_SIZE = 10;
    int countData = 0;
    private Object[] keys = new Object[INITIAL_SIZE];
    private Object[] values = new Object[INITIAL_SIZE];

    private boolean checkCapacity(int value) {
        return value >= keys.length;
    }

    @Override
    public void put(K key, V value) {
        int position = exists(key) < 0 ? countData : exists(key);
        if (checkCapacity(position)) {
            copyArrays();
        }
        keys[position] = key;
        values[position] = value;
        countData++;
    }

    private void copyArrays() {
        keys = Arrays.copyOf(keys, (keys.length * 3) / 2 + 1);
        values = Arrays.copyOf(values, (values.length * 3) / 2 + 1);
    }

    @Override
    public V get(K key) {
        int position = exists(key);
        if (position < 0) {
            System.out.println("This key doesn't exist, please check");
            return null;
        }
        return (V) values[position];
    }

    public int exists(K k) {
        for (int i = 0; i < countData; i++) {
            if (keys[i] == (k)
                    || keys[i] != null && keys[i].equals(k)) {
                return i;
            }
        }
        return -1;
    }
}
