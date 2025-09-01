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

    private static final int MAX_SIZE = 10;
    private int count = 0;
    private Entry<K, V>[] entries;

    public StorageImpl() {
        this.entries = new Entry[MAX_SIZE];
    }

    private boolean keysEqual(K k1, K k2) {
        return (k1 == null && k2 == null) || (k1 != null && k1.equals(k2));
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (keysEqual(entries[i].key, key)) {
                entries[i].value = value;
                return;
            }
        }

        if (count < MAX_SIZE) {
            entries[count++] = new Entry<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (keysEqual(entries[i].key, key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
