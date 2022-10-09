package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_LENGTH = 10;

    private Object[] keyArray;
    private Object[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = new Object[MAX_LENGTH];
        valueArray = new Object[MAX_LENGTH];
    }

    private int getPosition(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (getPosition(key) >= 0) {
            this.valueArray[getPosition(key)] = value;
            return;
        }
        this.keyArray[size] = key;
        this.valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (getPosition(key) >= 0) {
            return (V) valueArray[getPosition(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
