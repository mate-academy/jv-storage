package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int size;
    private final Entry<K, V>[] entries;

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.entries = (Entry<K, V>[]) new Entry[MAX_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            entries[keyIndex].setValue(value);
            return; // Вихід з методу після оновлення значення
        }
        if (size < MAX_CAPACITY) {
            entries[size++] = new Entry<>(key, value);
        } 
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex == -1) {
            return null;        
        }
        return entries[keyIndex].getValue();
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(entries[i].getKey(), key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
