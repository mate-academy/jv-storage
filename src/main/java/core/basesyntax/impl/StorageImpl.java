package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final Pair<K, V>[] arrayOfPairs;
    private int elementsAdded;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.arrayOfPairs = (Pair<K, V>[]) new Pair[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (elementsAdded >= MAX_CAPACITY) {
            throw new RuntimeException("The maximum capacity is 10");
        }
        for (Pair<K, V> element : arrayOfPairs) {
            if (element != null && equals(element.getKey(), key)) {
                element.setValue(value);
                return;
            }
        }
        for (int i = 0; i < arrayOfPairs.length; i++) {
            if (arrayOfPairs[i] == null) {
                arrayOfPairs[i] = new Pair<>(key, value);
                elementsAdded++;
                return;
            }
        }
    }
    
    @Override
    public V get(K key) {
        for (Pair<K, V> element : arrayOfPairs) {
            if (element != null && equals(element.getKey(), key)) {
                return element.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementsAdded;
    }
}
