package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    // Initialize an array of fixed size (10 elements) to store key-value pairs of type Entry<K, V>.
    private Entry<K, V>[] entries = (Entry<K, V>[]) new Entry[10];
    // The (Entry<K, V>[]) cast is used to remove type incompatibility warnings.
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && keyComparison(entries[i].key, key)) {
                entries[i].value = value;
                return;
            }
        }
        if (size < entries.length) {
            entries[size] = new Entry<>(key, value);
            size++;
        } else {
            throw new IllegalStateException("Storage has reached maximum number of items");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && keyComparison(entries[i].key, key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keyComparison(K key1, K key2) {
        if (key1 == key2) {
            return true;
        }
        if (key1 == null || key2 == null) {
            return false;
        }
        return key1.equals(key2);
    }

    private class Entry<K, E> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
