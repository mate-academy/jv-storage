package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXSIZE = 10;
    private int maxIndex = 0;

    private Object[] keys = new Object[MAXSIZE];
    private Object[] values = new Object[MAXSIZE];

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < maxIndex; i++) {
            if (keys[i] != null && keys[i].equals(key) || (keys[i] == null && key == null)) {
                values[i] = value;
                return;
            }
        }

        if (maxIndex >= MAXSIZE) {
            throw new RuntimeException("Array index " + maxIndex
                      + " out of bounds " + maxIndex);
        }

        keys[maxIndex] = key;
        values[maxIndex] = value;

        maxIndex++;
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < maxIndex; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (keys[i] == null && key == null)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return maxIndex;
    }
}
