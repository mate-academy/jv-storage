package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ARRAY_SIZE = 10;
    private int curretElement = 0;
    private Object[] keyArray = new Object[MAX_ARRAY_SIZE];
    private Object[] valueArray = new Object[MAX_ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < curretElement; i++) {
            if (checkEquals(key, keyArray[i])) {
                valueArray[i] = value;
                curretElement--;
            }
        }
        keyArray[curretElement] = key;
        valueArray[curretElement] = value;
        curretElement++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < curretElement; i++) {
            if (checkEquals(key, keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return curretElement;
    }

    private boolean checkEquals(K key, Object keyArray) {
        return ((key == null && keyArray == null)
                || (keyArray != null && keyArray.equals(key)));
    }
}
