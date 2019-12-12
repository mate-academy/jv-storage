package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static int MAX_SIZE = 10;
    private int numOfElem = 0;
    private Object[] arrOfKey = new Object[MAX_SIZE];
    private Object[] arrOfValue = new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < numOfElem; i++) {
            if (key == null || key.equals(arrOfKey[i])) {
                arrOfValue[i] = value;
                return;
            }
        }
        arrOfKey[numOfElem] = key;
        arrOfValue[numOfElem] = value;
        numOfElem++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrOfKey.length; i++) {
            if (key == null || key.equals(arrOfKey[i])) {
                return (V) arrOfValue[i];
            }
        }
        return null;
    }
}
