package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_SIZE = 10;
    public static final int NO_RESULT = -1;
    private final Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Pair[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        final Pair<K, V> newPair = new Pair<>(key, value);
        int position = findExistingPositionByKey(key);
        if (position != NO_RESULT) {
            storage[position] = newPair;
        } else if (size < STORAGE_SIZE) {
            storage[size++] = newPair;
        } else {
            throw new ArrayStoreException("Storage is out of free space!");
        }
    }

    @Override
    public V get(K key) {
        int position = findExistingPositionByKey(key);
        if (position != NO_RESULT) {
            return storage[position].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findExistingPositionByKey(K key) {
        for (int i = 0; i < size; i++) {
            final K storageKey = storage[i].getKey();
            if (storageKey == null && key == null
                    || storageKey != null && storageKey.equals(key)) {
                return i;
            }
        }
        return NO_RESULT;
    }

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<K, V> pair = (Pair<K, V>) o;
            return (getKey() == pair.getKey() || getKey() != null
                    && getKey().equals(pair.getKey()))
                    && (getValue() == pair.getValue() || getValue() != null
                    && getValue().equals(pair.getValue()));
        }

        @Override
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode() / 7)
                    + (getValue() == null ? 0 : getValue().hashCode() / 7);
        }
    }
}
