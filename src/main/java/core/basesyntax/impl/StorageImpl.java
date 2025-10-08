package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int currentSize;
    private final Pair<K, V>[] storageArray;

    public StorageImpl() {
        storageArray = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> currentPair = getPair(key);

        if (currentPair != null) {
            currentPair.setValue(value);
        } else if (currentSize < MAX_ITEMS_NUMBER) {
            storageArray[currentSize] = new Pair<K, V>(key, value);
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        Pair<K, V> currentPair = getPair(key);
        if (currentPair != null) {
            return currentPair.getValue();
        }

        return null;
    }

    private Pair<K, V> getPair(K key) {
        for (Pair<K, V> kvPair : storageArray) {
            if (isKeyEqual(kvPair, key)) {
                return kvPair;
            }
        }

        return null;
    }

    private boolean isKeyEqual(Pair<K, V> kvPair, K key) {
        return (kvPair == null ? key == null
                : (kvPair.getKey() == null ? key == null
                : kvPair.getKey().equals(key)));
    }
}
