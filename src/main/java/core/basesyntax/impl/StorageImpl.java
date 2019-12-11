package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static int MAX_SIZE = 10;
    private int numOfElem = 0;
    private Object[] arrOfKey = new Object[MAX_SIZE];
    private Object[] arrOfValue = new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        if (numOfElem < MAX_SIZE) {
            for (int i = 0; i < numOfElem + 1; i++) {
                if (key == null) {
                    arrOfKey[i] = null;
                    arrOfValue[i] = value;
                    return;
                } else {
                    if (key == arrOfKey[i] || key.equals(arrOfKey[i])) {
                        arrOfValue[i] = value;
                        break;
                    } else if (i == numOfElem) {
                        arrOfKey[i] = key;
                        arrOfValue[i] = value;
                    }
                }
            }
            numOfElem++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < numOfElem + 1; i++) {
            if (key == null) {
                if (key == arrOfKey[i]) {
                    return (V) arrOfValue[i];
                }
            } else if (key == arrOfKey[i] || key.equals(arrOfKey[i])) {
                return (V) arrOfValue[i];
            }
        }
        return null;
    }
}
