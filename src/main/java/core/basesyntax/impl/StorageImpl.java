package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        sizeCheck();
        int index = getIndexByKey(key);
        if (index > 0) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void sizeCheck() {
        if (size <= MAX_SIZE) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Error. Storage is full. Size: " + size);
    }

    private int getIndexByKey(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                index = i;
            }
        }
        return index;
    }
}
