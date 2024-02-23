package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private Pair<K, V>[] storageArray;
    private int size;

    public StorageImpl() {
        this.storageArray = new Pair[MAX_STORAGE_SIZE];
        this.size = size;
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_STORAGE_SIZE) {
            throw new RuntimeException("Storage is full!");
        }

        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            @SuppressWarnings("unchecked")
            Pair<K, V> pair = storageArray[i];
            if (pair != null) {
                if ((key == pair.getKey())
                        || (key != null && key.equals(pair.getKey()))) {
                    pair.setValue(value);
                    return;
                }
            }
        }
        storageArray[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            Pair<K, V> pair = storageArray[i];
            if ((key == pair.getKey())
                    || (key != null && key.equals(pair.getKey()))) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public class Pair<K, V> {
        private K key;
        private V value;

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

        public void setValue(V value) {
            this.value = value;
        }
    }
}
