package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }

    private static final int MAX_STORAGE_SIZE = 10;
    private int size = 0;
    private Entry<K, V>[] entries = (Entry<K, V>[]) new Entry[MAX_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            K currentKey = entries[i].getKey();
            if (currentKey == key || (currentKey != null && currentKey.equals(key))) {
                entries[i].setValue(value);
                return;
            }
        }
        entries[size] = new Entry<>(key, value);
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = entries[i].getKey();
            if (currentKey == key || (currentKey != null && currentKey.equals(key))) {
                return entries[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

