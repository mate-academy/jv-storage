package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private final Entry<K, V>[] entries;
    private int size;

    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        entries = new Entry[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index >= 0) {
            entries[index].value = value;
        } else {
            if (size >= MAX_CAPACITY) {
                throw new RuntimeException("Storage is full");
            }
            entries[size++] = new Entry<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return (index >= 0) ? entries[index].value : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? entries[i].key == null : key.equals(entries[i].key)) {
                return i;
            }
        }
        return -1;
    }
}
