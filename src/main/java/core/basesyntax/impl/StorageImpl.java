package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int counter;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH];
        values = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        boolean flag = false;
        int neededIndex = 0;
        if (key == null) {
            for (int i = 0; i < counter; i++) {
                if (keys[i].equals("null")) {
                    flag = true;
                    neededIndex = i;
                }
            }
        } else {
            for (int i = 0; i < counter; i++) {
                if (keys[i].equals(key)) {
                    flag = true;
                    neededIndex = i;
                }
            }
        }
        if (flag) {
            if (key == null) {
                values[neededIndex] = value;
            } else {
                values[neededIndex] = value;
            }
        } else {
            if (key == null) {
                keys[counter] = (K) "null";
            } else {
                keys[counter] = key;
            }
            values[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < counter; i++) {
                if (keys[i] == "null") {
                    return values[i];
                }
            }
        } else {
            for (int i = 0; i < counter; i++) {
                if (keys[i].equals(key)) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
