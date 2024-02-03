package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Pair[] elements = new Pair[MAX_SIZE];
    private int size = 0;

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException("Array already full");
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[size] = new Pair<>(key, value);
                size++;
                break;
            } else if (elements[i].getKey() == null && key == null) {
                elements[i].setValue(value);
                break;
            } else if (elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                elements[i].setValue(value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                return null;
            }
            if (elements[i].getKey() == null && key == null) {
                return (V)elements[i].getValue();
            }
            if (elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                return (V) elements[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K,V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
