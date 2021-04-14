package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;
    private int size;
    private final K[] arrayKey;
    private final V[] arrayValue;

    public StorageImpl() {
        arrayKey = (K[]) new Object [CAPACITY];
        arrayValue = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrayKey[i] || (key != null && key.equals(arrayKey[i]))) {
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
        for (int i = 0; i < size; i++) {
            if (key == arrayKey[i] || (key != null && key.equals(arrayKey[i]))) {
                return arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
