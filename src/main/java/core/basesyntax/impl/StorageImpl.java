package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private final Pair<K, V>[] pairs = new Pair[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (Pair<K, V> p : pairs) {
            if (p.key == null || p.hasKey(key)) {
                p.key = key;
                p.value = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> p : pairs) {
            if (p.hasKey(key)) {
                return p.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int i = 0;
        for (Pair<K, V> p : pairs) {
            if (p.key != null) {
                i++;
            } else {
                return i;
            }
        }
        return i;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public boolean hasKey(K input) {
            if (key == null) {
                return false;
            }
            if (input == key) {
                return true;
            }
            if (input.getClass() != key.getClass()) {
                return false;
            }
            return Objects.equals(input, key);
        }
    }
}
