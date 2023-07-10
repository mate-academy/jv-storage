package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;

    private final K[] keys = (K[]) new Object[MAX_LENGTH];
    private final V[] values = (V[]) new Object[MAX_LENGTH];

    private int size = 0;

    @Override
    public void put(K key, V value) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == -1 && thereIsFreeSpace()) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[keyIndex] = value;
    }

    @Override
    public V get(K key) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == -1) {
            return null;
        }
        return values[keyIndex];

    }

    @Override
    public int size() {
        return size;
    }

    private boolean thereIsFreeSpace(){
        if (size >= keys.length) {
            throw new RuntimeException("Array if filled");
        }
        return true;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
