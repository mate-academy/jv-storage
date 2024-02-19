package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size = 0;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        keyArray = new Object[CAPACITY];
        valueArray = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqualKey(key, i)) {
                valueArray[i] = value;
                return;
            }
        }
        if (size < CAPACITY) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqualKey(key, i)) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEqualKey(K key, int i) {
        return key == keyArray[i] || key != null && key.equals(keyArray[i]);
    }

}
