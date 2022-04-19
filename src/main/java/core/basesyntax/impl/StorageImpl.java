package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final Pair<K, V>[] storage = new Pair[10];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (Pair<K, V> pair : storage) {
            if (pair == null) {
                continue;
            }
            if (key == null) {
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            } else if (key.equals(pair.key)) {
                pair.setValue(value);
                return;
            }
        }

        Pair<K, V> pair = new Pair<>(key, value);
        storage[count++] = pair;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storage) {
            if (pair == null) {
                continue;
            }
            if (pair.getKey() == null && key == null) {
                return pair.getValue();
            } else if (pair.getKey() == null) {
                continue;
            } else if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
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
