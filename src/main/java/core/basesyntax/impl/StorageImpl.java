package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final Integer STORE_SIZE = 10;
    private Object[] keyArr;
    private Object[] valueArr;
    private int lengthOfActualValue = 0;

    public StorageImpl() {
        valueArr = (V[]) new Object[STORE_SIZE];
        keyArr = (K[]) new Object[STORE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lengthOfActualValue; i++) {
            if (compareValue(keyArr[i], key)) {
                valueArr[i] = value;
                return;
            }
        }
        keyArr[lengthOfActualValue] = key;
        valueArr[lengthOfActualValue] = value;
        lengthOfActualValue++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lengthOfActualValue; i++) {
            if (compareValue(keyArr[i], key)) {
                return (V) valueArr[i];
            }
        }
        return null;
    }

    private boolean compareValue(Object obj1, Object obj2) {
        return (obj1 == obj2) || (obj1 != null && obj1.equals(obj2));
    }

    @Override
    public int size() {
        return lengthOfActualValue;
    }
}
