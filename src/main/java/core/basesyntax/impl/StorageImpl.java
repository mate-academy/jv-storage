package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;

    private int size = 0;

    private V[] valueArray;
    private K[] keyArray;

    /*V[] valueArray = (V[]) Array.newInstance(V ,MAX_ELEMENTS_NUMBER);
    K[] keyArray = (K[]) Array.newInstance(Class<K>, MAX_ELEMENTS_NUMBER); */

    public StorageImpl() {
        valueArray = (V[]) new Object[MAX_ELEMENTS_NUMBER];
        keyArray = (K[]) new Object[MAX_ELEMENTS_NUMBER];

    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (key == null && keyArray[i] == null && valueArray[i] != null) {
                valueArray[i] = value;
                return;
            }
            if (key == null) {
                continue;
            }
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (valueArray[i] == null && keyArray[i] == null) {
                valueArray[i] = value;
                keyArray[i] = key;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == key) {
                return valueArray[i];
            }
            if (key == null || keyArray[i] == null) {
                continue;
            }
            if (keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
