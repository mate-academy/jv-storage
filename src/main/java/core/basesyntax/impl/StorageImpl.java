package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LEN = 10;
    @SuppressWarnings("unchecked")
    private final Entry[] entries = (Entry[]) Array.newInstance(Entry.class, ARRAY_LEN);
    private int size = 0;

    @Override
    public void put(K key, V value) {
        Entry entry = findEntry(key);

        if (entry == null) {
            checkArraySize();
            entries[size++] = new Entry(key, value);
        } else {
            entry.setValue(value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Entry entry = entries[i];

            if (Objects.equals(key, entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Entry findEntry(K key) {
        for (int i = 0; i < size; i++) {
            Entry entry = entries[i];

            if (Objects.equals(key, entry.getKey())) {
                return entry;
            }
        }

        return null;
    }

    private void checkArraySize() {
        if (size == ARRAY_LEN) {
            throw new RuntimeException("Storage is full. Maximum capacity of " + ARRAY_LEN
                    + " reached.");
        }
    }

    private class Entry {
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
