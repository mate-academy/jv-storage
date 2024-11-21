package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> extends Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final Entry<K, V>[] storage;
    private int count;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.storage = new Entry[MAX_CAPACITY];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
        if (count < MAX_CAPACITY) {
            storage[count++] = new Entry<>(key, value);
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(storage[i].key, key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    public int size() {
        return count;
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}