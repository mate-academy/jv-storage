package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_VOLUME = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_STORAGE_VOLUME];
        valueArray = (V[]) new Object[MAX_STORAGE_VOLUME];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (checkElementStorageIsFree(i)) {
                keyArray[i] = key;
                valueArray[i] = value;
                size++;
                break;
            }
            if (checkKeyEquality(i, key)) {
                valueArray[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (checkKeyEquality(i, key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkElementStorageIsFree(int i) {
        return keyArray[i] == null && valueArray[i] == null;
    }

    private boolean checkKeyEquality(int i, K key) {
        return keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key));
    }
}
