package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private int flag;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[SIZE];
        valueArray = (V[]) new Object[SIZE];
        flag = 0;
    }

    private boolean checkKey(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < flag; i++) {
            if (checkKey(key, keyArray[i])) {
                valueArray[i] = value;
                break;
            }
        }
        keyArray[flag] = key;
        valueArray[flag] = value;
        flag++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < flag; i++) {
            if (checkKey(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }
}
