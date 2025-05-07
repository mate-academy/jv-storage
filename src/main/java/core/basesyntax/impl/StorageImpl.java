package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_ELEMENTS = 10;
    private int size;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ARRAY_ELEMENTS];
        valueArray = (V[]) new Object[MAX_ARRAY_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(keyArray[i]))
                    || (key == keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        if (size < MAX_ARRAY_ELEMENTS) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            throw new RuntimeException("Can't put the data into a Storage - Storage is full ");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(keyArray[i]))
                    || (key == keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
