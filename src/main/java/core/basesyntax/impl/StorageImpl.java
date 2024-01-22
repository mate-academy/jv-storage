package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DOUBLE_ARRAY_SIZE = 20;
    private Object[] array = new Object[DOUBLE_ARRAY_SIZE];
    private int arrayIterator = 0;
    private int sizeCounter = 0;

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            for (int i = 0; i < sizeCounter * 2 - 1; i++) {
                if (i % 2 == 0) {
                    if (key == null && array[i] == null) {
                        array[i + 1] = value;
                        break;
                    }
                    if (key != null && key.equals(array[i])) {
                        array[i + 1] = value;
                        break;
                    }
                }
            }
        } else {
            if (sizeCounter <= 10) {
                array[arrayIterator++] = key;
                array[arrayIterator++] = value;
                sizeCounter++;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeCounter * 2 - 1; i++) {
            if (i % 2 == 0) {
                if (key == null && array[i] == null) {
                    return (V) array[i + 1];
                }
                if (key != null && key.equals(array[i])) {
                    return (V) array[i + 1];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeCounter;
    }
}
