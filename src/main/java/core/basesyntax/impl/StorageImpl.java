package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private K key;
    private V value;
    private final Object[] arrayKey = new Object[MAXIMUM_CAPACITY];
    private final Object[] arrayValue = new Object[MAXIMUM_CAPACITY];
    private int size = 0;

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (((key != null) && key.equals(arrayKey[i])) || (key == null && arrayKey[i] == key)) {
                arrayValue[i] = value;
                return;
            }
        }
        arrayKey[size] = key;
        arrayValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (size == 0 && (key == null && arrayKey[size] == key)) {
            return (V) arrayValue[size];
        }
        for (int i = 0; i < size; i++) {
            if (key == null && arrayKey[i] == null || key != null && key.equals(arrayKey[i])) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
