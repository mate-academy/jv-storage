package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_ARR = 10;
    private int size = 0;
    private final Object[] keyArr = new Object[SIZE_ARR];
    private final Object[] valueArr = new Object[SIZE_ARR];

    @Override
    public void put(K key, V value) {
        int keyIndex = indexCheck(key);

        if (keyIndex == -1) {
            keyArr[size] = key;
            valueArr[size] = value;
            size++;
        } else {
            valueArr[keyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = indexCheck(key);

        if (keyIndex != -1) {
            return (V) valueArr[keyIndex];
        }
        return null;
    }

    private int indexCheck(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArr[i] == null)
                    || (keyArr[i] != null && keyArr[i].equals(key))) {
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
