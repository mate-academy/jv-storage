package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int size;
    private Entry<K, V>[] box = new Entry[MAX_ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry(key, value);
        for (int i = 0; i < size; i++) {
            if (box[i].equals(entry)) {
                box[i].value = value;
                return;
            }
        }
        box[size] = entry;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (box[i].key == key || key != null && key.equals(box[i].key)) {
                return box[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry<?, ?> current = (Entry<?, ?>)obj;
            return (key == null && current.key == null)
                    || (key != null && key.equals(current.key));
        }

        @Override
        public int hashCode() {
            int result = 17;
            result += 31 * (key != null ? key.hashCode() : 0);
            result += 31 * (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
