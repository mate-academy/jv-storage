package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keyArr = new Object[MAX_SIZE];
    private final Object[] valueArr = new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        int keyIndex = findIndexForKey(key);

        if (keyIndex < 0 && checkSize(size)) {
            keyArr[size] = key;
            valueArr[size] = value;
            size++;
            return;
        }
        valueArr[keyIndex] = value;

    }

    @Override
    public V get(K key) {
        int keyIndex = findIndexForKey(key);

        if (keyIndex > -1) {
            return (V) valueArr[keyIndex];
        }
        return null;
    }

    private int findIndexForKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArr[i] == null)
                    || (keyArr[i] != null && keyArr[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkSize(int size) {
        return size <= MAX_SIZE;
    }

    @Override
    public int size() {
        return size;
    }
}
