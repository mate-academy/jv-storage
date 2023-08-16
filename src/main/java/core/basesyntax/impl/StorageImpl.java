package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Pair<K, V>[] storage;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        storage = (Pair<K, V>[]) new Pair[10];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].getKey(), key)) {
                storage[i].setValue(value);
                return;
            }
        }
        if (size < storage.length) {
            storage[size] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].getKey(), key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private final K key;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
