package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_QUANTITY = 10;
    private final int indexNotFound = -1;
    private int currentSize;
    private KeyValuePair<K, V>[] pairsArray;

    public StorageImpl() {
        pairsArray = new KeyValuePair[MAX_ELEMENTS_QUANTITY];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = checkIndex(key);
        if (index == indexNotFound) {
            pairsArray[currentSize++] = new KeyValuePair<>(key, value);
        } else {
            pairsArray[index].setValue(value);
        }
    }

    @Override
    public V get(K key) {
        int index = checkIndex(key);
        return index == indexNotFound ? null : pairsArray[index].getValue();
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int checkIndex(K key) {
        int index = indexNotFound;
        for (int i = 0; i < currentSize; i++) {
            if (pairsArray[i].getKey() == null ? pairsArray[i].getKey() == key
                    : pairsArray[i].getKey().equals(key)) {
                index = i;
            }
        }
        return index;
    }
}
