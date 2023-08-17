package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_QUANTITY = 10;
    private int currentSize;
    private KeyValuePair<K, V>[] pairsArray;

    public StorageImpl() {
        pairsArray = new KeyValuePair[MAX_ELEMENTS_QUANTITY];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        if (currentSize == 0) {
            pairsArray[currentSize++] = new KeyValuePair<>(key, value);
        } else {
            boolean reWrite = false;
            for (int i = 0; i < currentSize; i++) {
                if (pairsArray[i].getKey() == null ? pairsArray[i].getKey() == key
                        : pairsArray[i].getKey().equals(key)) {
                    pairsArray[i].setValue(value);
                    reWrite = true;
                    break;
                }
            }
            if (!reWrite) {
                pairsArray[currentSize++] = new KeyValuePair<>(key, value);
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (pairsArray[i].getKey() == null ? pairsArray[i].getKey() == key
                    : pairsArray[i].getKey().equals(key)) {
                return pairsArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
