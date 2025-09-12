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

    private static final int MAX_CAPACITY = 10;
    private Entry<K, V>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        entries = new Entry[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != -1) {
            entries[index].value = value; // replace existing
            return;
        }
        if (size == entries.length) {
            throw new IllegalStateException("Map is full");
        }
        entries[size++] = new Entry<>(key, value);
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return (index != -1) ? entries[index].value : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(entries[i].key, key)) {
                return i;
            }
        }
        return -1;
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
