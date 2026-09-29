package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ARRAY_SIZE = 10;
    public static final int START_SIZE = 0;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object [MAX_ARRAY_SIZE];
        values = (V[]) new Object [MAX_ARRAY_SIZE];
        size = START_SIZE;
    }

    @Override
    public void put(K key, V value) {
        if (size() == MAX_ARRAY_SIZE) {
            System.out.println("The storage is full");
            return;
        }

        int index = getIndex(key);

        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index > -1 ? values[index] : null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
