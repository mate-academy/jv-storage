package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NOT_FOUND_INDEX = -1;
    private int size;
    private final K[] keyArr;
    private final V[] valArr;

    public StorageImpl() {
        keyArr = (K[]) new Object[MAX_SIZE];
        valArr = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != NOT_FOUND_INDEX) {
            valArr[index] = value;
            return;
        }
        if (index < MAX_SIZE) {
            valArr[size] = value;
            keyArr[size] = key;
            size++;
        } else {
            throw new RuntimeException("Can't write to array! Index out of borders!"
                    + "Max size is: " + MAX_SIZE);
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index != NOT_FOUND_INDEX) {
            return valArr[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeysEqual(key, i)) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }

    private boolean isKeysEqual(K key, int i) {
        return key == keyArr[i] || (keyArr[i] != null && keyArr[i].equals(key));
    }
}

