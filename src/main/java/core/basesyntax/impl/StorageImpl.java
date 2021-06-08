package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private int currentSize;
    private K[] keyArray = (K[]) new Object[MAX_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (key == keyArray[i]) {
                valueArray[i] = value;
                return;
            }

            if (key != null && key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[currentSize] = key;
        valueArray[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < currentSize; i++) {
            if (key == keyArray[i]) {
                result = valueArray[i];
                break;
            }

            if (key != null && key.equals(keyArray[i])) {
                result = valueArray[i];
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
