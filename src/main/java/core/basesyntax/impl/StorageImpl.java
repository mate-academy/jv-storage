package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    public StorageImpl() {
        this.keyStorage = (K[]) new Object[MAX_LENGTH];
        this.valueStorage = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (getKeyIndex(key) != null) {
            valueStorage[getKeyIndex(key)] = value;
            return;
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (getKeyIndex(key) != null) {
            return valueStorage[getKeyIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Integer getKeyIndex(K key) {
        Integer index = null;
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || key != null && key.equals(keyStorage[i])) {
                index = i;
            }
        }
        return index;
    }

}
