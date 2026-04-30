package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Entry<K, V>[] entries;
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
        entries = new Entry[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            boolean keysAreEqual = entries[i].key == null
                    ? key == null
                    : entries[i].key.equals(key);
            if (keysAreEqual) {
                entries[i].value = value;
                return;
            }
        }
        entries[size] = new Entry<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            boolean keysAreEqual = entries[i].key == null
                    ? key == null
                    : entries[i].key.equals(key);
            if (keysAreEqual) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
