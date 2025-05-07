package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private int size = 0;
    private Pair[] pairsArray = new Pair[ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == pairsArray[i].getKey()
                    || (key != null && key.equals(pairsArray[i].getKey()))) {
                pairsArray[i].setValue(value);
                return;
            }
        }
        Pair<K,V> newPair = new Pair<>();
        newPair.setKey(key);
        newPair.setValue(value);
        pairsArray[size] = newPair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == pairsArray[i].getKey()
                    || (key != null && key.equals(pairsArray[i].getKey()))) {
                return (V) pairsArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
