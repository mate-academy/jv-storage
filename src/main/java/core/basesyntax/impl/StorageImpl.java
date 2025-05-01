package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final Pair<K, V>[] pairs;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.pairs = (Pair<K, V>[]) new Pair[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i] != null && equals(pairs[i].getKey(), key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        if (size >= MAX_CAPACITY) {
            throw new RuntimeException("The maximum capacity is 10");
        }
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i] == null) {
                pairs[i] = new Pair<>(key, value);
                size++;
                return;
            }
        }

    }
    
    @Override
    public V get(K key) {
        for (Pair<K, V> element : pairs) {
            if (element != null && equals(element.getKey(), key)) {
                return element.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean equals(K first, K second) {
        if (first == null) {
            return second == null;
        }
        return first.equals(second);
    }
}
