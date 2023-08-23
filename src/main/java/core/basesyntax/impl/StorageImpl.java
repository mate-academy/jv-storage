package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAXIMUM_SIZE = 10;
    private Pair<K, V>[] storage;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        storage = new Pair[MAXIMUM_SIZE];
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public void put(K key, V value) {
        if (size < MAXIMUM_SIZE) {
            int index = getIndex(key);
            if (index == -1) {
                storage[size] = new Pair<>(key, value);
                size++;
            } else {
                storage[index].setValue(value);
            }
        }
    }

    public int getIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if (key != null && key.equals(storage[i].getKey())
                    || key == storage[i].getKey()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return (index != -1) ? storage[index].getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }
}
