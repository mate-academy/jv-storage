package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int storageSize;
    private int lastIndex;

    public StorageImpl() {
        keyArray = (K[]) new Object[ARRAY_LENGTH];
        valueArray = (V[]) new Object[ARRAY_LENGTH];
        storageSize = 0;
        lastIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean uniqueKey = true;
        for (int i = 0; i < keyArray.length; i++) {
            if ((keyArray[i] == null && key == null && valueArray[i] != null)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                valueArray[i] = value;
                uniqueKey = false;
                break;
            }
        }
        if (uniqueKey) {
            keyArray[lastIndex] = key;
            valueArray[lastIndex] = value;
            storageSize++;
            lastIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if ((keyArray[i] == null && key == null)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
