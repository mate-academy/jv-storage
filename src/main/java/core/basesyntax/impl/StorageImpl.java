package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private Pair<K, V>[] pairs = new Pair[MAX_STORAGE_LENGTH];
    private int size;

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

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        if (issetKey(key)) {
            setValueByKey(key, value);
        } else {
            pairs[size] = new Pair<K, V>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (equals(pairs[i].getKey(), key)) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void setValueByKey(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equals(pairs[i].getKey(), key)) {
                pairs[i].setValue(value);
            }
        }
    }

    private boolean issetKey(K key) {
        for (int i = 0; i < size; i++) {
            if (equals(pairs[i].getKey(), key)) {
                return true;
            }
        }
        return false;
    }

    private boolean equals(K firstValue, K secondValue) {
        if (firstValue == secondValue || (firstValue != null && firstValue.equals(secondValue))) {
            return true;
        }

        return false;
    }
}
