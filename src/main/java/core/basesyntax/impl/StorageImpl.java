package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final Entry<K, V>[] storage;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.storage = (Entry<K, V>[]) new Entry[CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == CAPACITY) {
            throw new RuntimeException("Storage is full");
        }
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
        storage[size] = new Entry<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].key, key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
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
