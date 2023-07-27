package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final List<Entry<K, V>> entries;

    public StorageImpl() {
        this.entries = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            entries.get(index).setValue(value);
        } else {
            if (entries.size() == MAX_SIZE) {
                throw new IllegalStateException("Storage is full.");
            }
            entries.add(new Entry<>(key, value));
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? entries.get(index).getValue() : null;
    }

    @Override
    public int size() {
        return entries.size();
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < entries.size(); i++) {
            Entry<K, V> entry = entries.get(i);
            if ((key == null && entry.getKey() == null)
                    || (key != null && key.equals(entry.getKey()))) {
                return i;
            }
        }
        return -1;
    }

    private static class Entry<K, V> {
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
