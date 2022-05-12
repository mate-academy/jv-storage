package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private final Pair<K, V>[] storage = new Pair[DEFAULT_CAPACITY];
    private int size;

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (storage[i].getKey() == key) {
                    storage[i].setValue(value);
                    return;
                }
            } else if (key.equals(storage[i].key)) {
                storage[i].setValue(value);
                return;
            }
        }

        Pair<K, V> pair = new Pair<>(key, value);
        storage[size++] = pair;
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == null && key == null) {
                return storage[i].getValue();
            } else if (storage[i].getKey() == null) {
                continue;
            } else if (storage[i].getKey().equals(key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (key != null ? !key.equals(pair.key) : pair.key != null) {
                return false;
            }
            return value != null ? value.equals(pair.value) : pair.value == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
