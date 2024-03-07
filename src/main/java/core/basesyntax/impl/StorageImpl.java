package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private final Pair[] storage;
    private int size;

    public StorageImpl() {
        this.storage = new Pair[MAX_STORAGE_LENGTH];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        Pair newData = new Pair(key, value);

        for (int i = 0; i < size; i++) {
            if (key == null && storage[i] != null && storage[i].getKey() == null
                    || (storage[i] != null
                    && storage[i].getKey() != null
                    && storage[i].getKey().equals(key))
            ) {
                storage[i].setValue(value);
                return;
            }
        }

        if (size == MAX_STORAGE_LENGTH) {
            throw new RuntimeException(
                    "The storage is totally filled - impossible to add new data"
            );
        }
        storage[size] = newData;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if ((key == null && storage[i] != null && storage[i].getKey() == null)
                    || (storage[i] != null
                    && storage[i].getKey() != null
                    && storage[i].getKey().equals(key))
            ) {
                return (V) storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private V value;
        private K key;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair current = (Pair) o;
            return Objects.equals(key, current.key)
                    && Objects.equals(value, current.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
