package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    @SuppressWarnings("unchecked")
    private Bucket<K, V>[] storage = (Bucket<K, V>[]) new Bucket[10];
    private int filled = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < filled; i++) {
            if (Objects.equals(storage[i].getKey(), key)) {
                storage[i] = new Bucket<>(key, value);
                return;
            }
        }

        storage[filled] = new Bucket<>(key, value);
        filled++;
    }

    @Override
    public V get(K key) {
        for (Bucket<K, V> bucket : storage) {
            if (bucket != null && Objects.equals(bucket.getKey(), key)) {
                return bucket.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return filled;
    }

    private static class Bucket<K, V> {
        private final K key;
        private final V value;

        private Bucket(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
