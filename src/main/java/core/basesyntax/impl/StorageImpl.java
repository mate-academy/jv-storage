package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;

    private Object[] keyArray;
    private Object[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = new Object[MAX_LENGTH];
        valueArray = new Object[MAX_LENGTH];
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
        return (getPosition(key) >= 0) ? (V) valueArray[getPosition(key)] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getPosition(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
