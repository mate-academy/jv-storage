package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int size = 0;
    private Entry<K, V>[] entries;

    public StorageImpl() {
        entries = new Entry[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((entries[i].key == key) || (key != null && key.equals(entries[i].key))) {
                entries[i].value = value;
                return;
            }
        }
        if (size < MAX_CAPACITY) {
            entries[size++] = new Entry<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((entries[i].key == key) || (key != null && key.equals(entries[i].key))) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
