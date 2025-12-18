package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Entry<K, V>[] entries = (Entry<K, V>[]) new Entry[MAX_CAPACITY];
    private int size = 0;

    private static class Entry<K, V> {
        private final K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(entries[i].key, key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);

        if (index != -1) {
            entries[index].value = value;
            return;
        }

        if (size == MAX_CAPACITY) {
            throw new RuntimeException("Storage is full");
        }

        entries[size] = new Entry<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return index == -1 ? null : entries[index].value;
    }

    @Override
    public int size() {
        return size;
    }
}
