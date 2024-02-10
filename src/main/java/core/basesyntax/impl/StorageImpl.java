package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Pair<K, V>[] elements;
    private int size;

    public StorageImpl() {
        elements = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException("Array already full");
        }
        for (Pair<K, V> pair : elements) {
            if (pair == null) {
                elements[size] = new Pair<>(key, value);
                size++;
                return;
            } else if (equalsKeys(key, pair.key)) {
                pair.value = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : elements) {
            if (pair == null) {
                return null;
            }
            if (equalsKeys(key, pair.key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean equalsKeys(K key, K elementsKey) {
        return key == elementsKey || key != null && key.equals(elementsKey);
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
