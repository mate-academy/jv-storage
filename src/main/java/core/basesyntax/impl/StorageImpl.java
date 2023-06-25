package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] arrKey;
    private Object[] arrValue;
    private int size;

    public StorageImpl() {
        arrKey = new Object[MAX_CAPACITY];
        arrValue = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (arrKey[i] == key || (key != null && key.equals(arrKey[i]))) {
                arrKey[i] = key;
                arrValue[i] = value;
                size -= 1;
            }
        }
        arrKey[size] = key;
        arrValue[size] = value;
        size += 1;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size; i++) {
            if (arrKey[i] == key || (key != null && key.equals(arrKey[i]))) {
                return (V) arrValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
