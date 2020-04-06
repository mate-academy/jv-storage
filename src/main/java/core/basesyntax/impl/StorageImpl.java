package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Entry<K, V>[] entries;

    public StorageImpl() {
        this.entries = new Entry[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                entries[i] = new Entry<>(key, value);
                return;
            } else if (key == entries[i].getKey()
                    || (key != null && key.equals(entries[i].getKey()))) {
                entries[i].setValue(value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        if (entries[0] == null) {
            return null;
        }
        for (int i = 0; i < entries.length; i++) {
            if (key == entries[i].getKey() || (key != null && key.equals(entries[i].getKey()))) {
                return entries[i].getValue();
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Entry<?, ?> entry = (Entry<?, ?>) o;

            if (key != null ? !key.equals(entry.key) : entry.key != null) {
                return false;
            }
            return value != null ? value.equals(entry.value) : entry.value == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
