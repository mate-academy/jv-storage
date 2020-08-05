package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT = 10;
    private K[] arrKey;
    private V[] arrValue;
    private int size;

    public StorageImpl() {
        arrKey = (K[]) new Object[MAX_ELEMENT];
        arrValue = (V[]) new Object[MAX_ELEMENT];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrKey[i] || key != null && key.equals(arrKey[i])) {
                arrValue[i] = value;
                return;
            }
        }
        arrKey[size] = key;
        arrValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == arrKey[i] || key != null && key.equals(arrKey[i])) {
                return arrValue[i];
            }
        }
        return null;
    }
}
