package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private final K[] keyArray = (K[]) new Object[ARRAY_LENGTH];
    private final V[] valueArray = (V[]) new Object[ARRAY_LENGTH];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (key == null) {
                if (keyArray[i] == null && valueArray[i] != null) {
                    index--;
                }
                break;
            }
            if (equals(key, keyArray[i])) {
                index--;
            }
        }
        keyArray[index] = key;
        valueArray[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        int indexOfValue = 0;
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (equals(keyArray[i], key)) {
                indexOfValue = i;
            }
            if (valueArray[i + 1] == null) {
                break;
            }
        }
        return valueArray[indexOfValue];
    }

    @Override
    public int size() {
        return index;
    }

    public boolean equals(K firstKey, K secondKey) {
        if (firstKey == secondKey) {
            return true;
        }
        if (firstKey == null || secondKey == null) {
            return false;
        }
        return firstKey.equals(secondKey);
    }
}
