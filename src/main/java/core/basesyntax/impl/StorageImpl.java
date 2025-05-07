package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keyArray;
    private Object[] valueArray;
    private int size;

    public StorageImpl() {
        this.keyArray = new Object[MAX_SIZE];
        this.valueArray = new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
        valueArray[size - 1] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || (keyArray[i] != null && keyArray[i].equals(key))) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
