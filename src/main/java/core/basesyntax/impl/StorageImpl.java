package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int capacity;
    private int size;
    private final float loadFactor = 0.75f;
    private final int defaultCapacity = 16;
    private Entry[] table;

    public StorageImpl() {
        this.capacity = defaultCapacity;
        this.size = 0;
        this.table = new Entry[defaultCapacity];
    }

    public StorageImpl(int capacity) {
        if (capacity < defaultCapacity) {
            capacity = defaultCapacity;
        }
        this.table = new Entry[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size > loadFactor * capacity) {
            Entry[] newTable = new Entry[capacity * 3 / 2];
            System.arraycopy(this.table, 0, newTable, 0, this.table.length);
            this.table = newTable;
        }
        int index;
        for (index = 0; index < size; index++) {
            Entry entry = table[index];
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
            }
        }
        table[size] = new Entry<K, V>(key, value);
        size++;
    }

    public boolean isExist(K key) {
        for (int i = 0; i < size; i++) {
            Entry entry = table[i];
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getForNullKey();
        }
        for (int i = 0; i < size; i++) {
            Entry entry = table[i];
            if (entry.getKey().equals(key)) {
                return (V) entry.getValue();
            }
        }
        return null;
    }

    public V getForNullKey() {
        for (int i = 0; i < size; i++) {
            Entry entry = table[i];
            if (entry.getKey() == null) {
                return (V) entry.getValue();
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Entry) {
                Entry o = (Entry) obj;
                return o.getKey().equals(this.key)
                        && o.getValue().equals(this.value);
            }
            return false;
        }
    }
}
