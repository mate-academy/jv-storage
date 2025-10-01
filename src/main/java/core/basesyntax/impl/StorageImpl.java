package core.basesyntax.impl;

import core.basesyntax.Storage;

/**
 * Simple fixed-size key-value storage.
 *
 * Null-handling policy:
 * - Null keys ARE allowed. Only one null key can exist (like any other duplicate key).
 * - Null values ARE allowed and stored as-is.
 */
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private static class Entry<K, V> {
        private final K key;
        private V value;

        Entry(K key, V value) {
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

    private final Entry<K, V>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.entries = (Entry<K, V>[]) new Entry[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != -1) {
            entries[index].setValue(value);
            return;
        }

        if (size < MAX_SIZE) {
            entries[size++] = new Entry<>(key, value);
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index != -1 ? entries[index].getValue() : null;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = entries[i].getKey();
            if (currentKey == null ? key == null : currentKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
