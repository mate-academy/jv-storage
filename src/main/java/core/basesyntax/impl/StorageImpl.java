package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final int maxCapacity = 10;
    private final Object[] arrKey = new Object [maxCapacity];
    private final Object[] arrValue = new Object [maxCapacity];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < maxCapacity; i++) {
            if (key != null) {
                if (arrKey[i] == null && arrValue[i] == null || key.equals(arrKey[i])) {
                    arrKey[i] = key;
                    arrValue[i] = value;
                    break;
                }
            }
            if (arrKey[i] == key) {
                arrKey[i] = key;
                arrValue[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < maxCapacity; i++) {
            if (key != null) {
                if (arrKey[i] == null && arrValue[i] == null || key.equals(arrKey[i])) {
                    return (V) arrValue[i];
                }
            }
            if (arrKey[i] == key) {
                return (V) arrValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < maxCapacity; i++) {
            if (arrValue[i] != null) {
                size += 1;
            }
        }
        return size;
    }
}
