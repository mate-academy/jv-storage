package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DOUBLE_ARRAY_SIZE = 20;
    private static final int ARRAY_SIZE = 10;
    private Object[] array = new Object[DOUBLE_ARRAY_SIZE];
    private int arrayIterator = 0;
    private int sizeCounter = 0;

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            int currentArraySize = sizeCounter * 2 - 1;
            for (int i = 0; i < currentArraySize; i+=2) {
                if (key == array[i] || (key != null && key.equals(array[i]))) {
                    array[i + 1] = value;
                    break;
                }
            }
        } else {
            if (sizeCounter <= ARRAY_SIZE) {
                array[arrayIterator++] = key;
                array[arrayIterator++] = value;
                sizeCounter++;
            }
        }
    }

    @Override
    public V get(K key) {
        int currentArraySize = sizeCounter * 2 - 1;
        for (int i = 0; i < currentArraySize; i+=2) {
            if (key == array[i] || (key != null && key.equals(array[i]))) {
                return (V) array[i + 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeCounter;
    }
}
