package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBERS_OF_ELEMENTS = 10;
    private Pair[] pairArray;
    private int size;

    public StorageImpl() {
        pairArray = new Pair[MAX_NUMBERS_OF_ELEMENTS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == pairArray[i].getKey()
                    || key != null && key.equals(pairArray[i].getKey())) {
                pairArray[i].setValue(value);
                return;
            }
        }
        Pair<K, V> pair = new Pair<>();
        pair.setKey(key);
        pair.setValue(value);
        pairArray[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == pairArray[i].getKey()
                    || key != null && key.equals(pairArray[i].getKey())) {
                return (V) pairArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
