package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size = 0;
    private Pair<K, V>[] storage = new Pair[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqual(key, storage[i].getKey())) {
                storage[i].setValue(value);
                return;
            }
        }
        storage[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqual(key, storage[i].getKey())) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEqual(Object first, Object second) {
        return first == second || first != null && first.equals(second);
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K newKey) {
            this.key = newKey;
        }

        public void setValue(V newValue) {
            this.value = newValue;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (key == null ? 0 : key.hashCode());
            result = 31 * result + (value == null ? 0 : value.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            if ((o.getClass().equals(Pair.class))) {
                Pair current = (Pair) o;
                boolean result = true;
                result = key != null && current.key != null ? result
                        && key.equals(current.getKey()) : result
                        && key == null && current.key == null;
                result = value != null && current.value != null ? result
                        && value.equals(current.getValue()) : result
                        && value == null && current.value == null;
                return result;
            }
            return false;
        }
    }
}
