package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Entry<K, V>[] store;
    private int position;

    public StorageImpl() {
        store = new Entry[CAPACITY];
        position = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < position; i++) {
            if (key == store[i].getKey() || (key != null && key.equals(store[i].getKey()))) {
                store[i].setValue(value);
                position++;
                break;
            }
        }
        store[position] = new Entry<>(key, value);
        position++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < position; i++) {
            if (key == store[i].getKey() || (key != null && key.equals(store[i].getKey()))) {
                return store[i].getValue();
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }
}
