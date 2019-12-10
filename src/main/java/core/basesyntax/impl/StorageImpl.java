package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    int countData = 0;
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];

    private int keyPosition(K key) {

        for (int i = 0; i < keys.length; i++) {

            if (keys[i] == null && key == null
                    || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return ++countData;
    }

    private boolean checkCapacity(int value) {
        return value >= keys.length;
    }

    @Override
    public void put(K key, V value) {
        int position = keyPosition(key);
        if (checkCapacity(position)) {
            copyArrays();
        }
        keys[position] = key;
        values[position] = value;
    }

    private void copyArrays() {
        keys = Arrays.copyOf(keys, (keys.length * 3) / 2 + 1);
        values = Arrays.copyOf(values, (values.length * 3) / 2 + 1);
    }

    @Override
    public V get(K key) {
        if (!exists(key)) {
            System.out.println("This key doesn't exist, please check");
            return null;
        }
        int position = keyPosition(key);

        return (V) values[position];
    }

    public boolean exists(K k) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && k == null
                    || keys[i] != null && keys[i].equals(k)) {
                return true;
            }
        }
        return false;
    }
}
