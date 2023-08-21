package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_QUANTITY = 10;
    private static final int indexNotFound = -1;
    private int currentSize;
    private Pair<K, V>[] pairs;

    public StorageImpl() {
        pairs = new Pair[MAX_ELEMENTS_QUANTITY];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = checkIndex(key);
        if (index == indexNotFound) {
            pairs[currentSize++] = new Pair<>(key, value);
        } else {
            pairs[index].setValue(value);
        }
    }

    @Override
    public V get(K key) {
        int index = checkIndex(key);
        return index == indexNotFound ? null : pairs[index].getValue();
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int checkIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (pairs[i].getKey() == key
                    || pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                return i;
            }
        }
        return indexNotFound;
    }
}
