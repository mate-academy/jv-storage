package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K,V> {
    public static final int LENGTH = 10;
    private K[] keyArr;
    private V[] valueArr;
    private int index;
    private int currElementsNumber = 0;

    public StorageImpl() {
        keyArr = (K[]) new Object[LENGTH];
        valueArr = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currElementsNumber; i++) {
            if (keyArr[i] == key
                    || keyArr[i] != null && keyArr[i].equals(key)) {
                valueArr[i] = value;
            }
        }
        keyArr[currElementsNumber] = key;
        valueArr[currElementsNumber] = value;
        currElementsNumber++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currElementsNumber; i++) {
            if (keyArr[i] == key || (keyArr[i] != null && keyArr[i].equals(key))) {
                return valueArr[i];
            }
        }
        return null;
    }
}
