package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keyArray = (K[]) new Object[10];
    private V[] valueArray = (V[]) new Object[10];
    private int freeIndex = 0;

    @Override
    public void put(K key, V value) {
        int i = 0;
        for (; i < freeIndex; i++) {
            if ((keyArray[i] != null
                    && keyArray[i].equals(key))
                    || (keyArray[i] == null
                    && keyArray[i] == key)) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[freeIndex] = key;
        valueArray[freeIndex++] = value;
    }

    @Override
    public V get(K key) {
        int i = 0;
        while (i < freeIndex) {
            if ((keyArray[i] != null
                    && keyArray[i].equals(key))
                    || (keyArray[i] == null
                    && keyArray[i] == key)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= freeIndex) {
            return null;
        }
        return valueArray[i];
    }

    @Override
    public int size() {
        return freeIndex;
    }
}
