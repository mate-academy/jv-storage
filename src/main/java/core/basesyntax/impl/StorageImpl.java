package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int arraySize = 10;
    private static final int empty = 0;
    private Pair[] store;
    private int elementsInArray;

    public StorageImpl() {
        store = new Pair[arraySize];
        elementsInArray = empty;
    }

    @Override
    public void put(K key, V value) {
        int position = getPosition(key);
        store[position] = new Pair<>(key, value);
        if (position == elementsInArray) {
            elementsInArray++;
        }
    }

    private int getPosition(K key) {
        if (elementsInArray == empty) {
            return empty;
        }
        for (int i = 0; i < elementsInArray; i++) {
            if (isKeyEquals((K) store[i].getKey(), key)) {
                return i;
            }
        }
        return elementsInArray;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsInArray; i++) {
            if (isKeyEquals((K) store[i].getKey(), key)) {
                return (V) store[i].getValue();
            }
        }
        return null;
    }

    private boolean isKeyEquals(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    @Override
    public int size() {
        return elementsInArray;
    }
}
