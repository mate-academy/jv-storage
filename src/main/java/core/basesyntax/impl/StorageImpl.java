package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size;
    private Object[] keyArr;
    private Object[] valueArr;

    public StorageImpl() {
        size = 0;
        keyArr = new Object[CAPACITY];
        valueArr = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size + 1; i++) {
            if (key == keyArr[i] || (key != null && key.equals(keyArr[i]))) {
                valueArr[i] = value;
                break;
            } else if (i == size && size < CAPACITY) {
                keyArr[i] = key;
                valueArr[i] = value;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size + 1; i++) {
            if (key == keyArr[i] || (key != null && key.equals(keyArr[i]))) {
                return (V) valueArr[i];
            }
        }
        return null;
    }
}


