package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        entries = new Entry[10];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(entries[i].key, key)) {
                entries[i].value = value; // replace
                return;
            }
        }
        if (size == entries.length) {
            throw new IllegalStateException("Map is full");
        }
        entries[size++] = new Entry<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(entries[i].key, key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEqual(K a, K b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }
}

