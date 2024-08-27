package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Entry<K, V>[] entries = (Entry<K, V>[]) new Entry[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && Objects.equals(entries[i].key, key)) {
                entries[i].value = value;
                return;
            }
        }
        if (size < entries.length) {
            entries[size] = new Entry<>(key, value);
            size++;
        } else {
            throw new IllegalStateException("Array is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && Objects.equals(entries[i].key, key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Entry<K, E> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
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
}
