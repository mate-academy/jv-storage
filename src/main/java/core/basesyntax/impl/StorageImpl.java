package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Node[] storage;
    private int size;

    public StorageImpl() {
        storage = new Node[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storage[i].key != null && storage[i].key.equals(key) || storage[i].key == key) {
                storage[i] = new Node(key, value);
                return;
            }
        }

        storage[size] = new Node(key, value);
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].key != null && storage[i].key.equals(key) || storage[i].key == key) {
                return (V) storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj instanceof Node) {
                Node entry = (Node) obj;

                return (this.key == entry.key
                        || this.key != null && this.key.equals(entry.key))
                        && (this.value == entry.value
                        || this.value != null && this.value.equals(entry.value));
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
            hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
            return hash;
        }
    }
}
