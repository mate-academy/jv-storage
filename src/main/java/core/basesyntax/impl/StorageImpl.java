package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private Container<K, V>[] storage;

    public StorageImpl() {
        this.storage = new Container[MAX_STORAGE_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (storage[i] == null) {
                storage[i] = new Container<>(key, value);
                size++;
                return;
            } else if (storage[i].getKey() == key
                    || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                storage[i].setValue(value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == key
                    || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    static class Container<K, V> {
        private K key;
        private V value;

        Container(K key, V value) {
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
