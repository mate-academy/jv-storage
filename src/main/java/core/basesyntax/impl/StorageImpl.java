package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    // Initialize an array of fixed size (10 elements) to store key-value pairs of type Entry<K, V>.
    private Entry<K, V>[] entries = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    // The (Entry<K, V>[]) cast is used to remove type incompatibility warnings.
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && keyComparison(entries[i].key, key)) {
                entries[i].value = value;
                return;
            }
        }
        if (size < entries.length) {
            entries[size] = new Entry<>(key, value);
            size++;
        } else {
            throw new IllegalStateException("Storage has reached maximum number of items");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && keyComparison(entries[i].key, key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keyComparison(K keyA, K keyB) {
        return keyA == keyB || (keyA != null && keyA.equals(keyB));
    }

    private class Entry<K, E> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
