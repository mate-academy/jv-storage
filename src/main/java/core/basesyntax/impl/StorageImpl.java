package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;

    public static final class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    private final Entry<K, V>[] array = (Entry<K, V>[]) new Entry[CAPACITY];
    private int size = 0;

    private boolean keysEqual(K a, K b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(array[i].key, key)) {
                array[i].value = value;
                return;
            }
        }

        if (size >= CAPACITY) {
            throw new RuntimeException("The storage is full.");
        }

        array[size++] = new Entry<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(array[i].key, key)) {
                return array[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
