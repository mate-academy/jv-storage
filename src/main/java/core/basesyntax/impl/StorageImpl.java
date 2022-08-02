package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int STORAGE_SIZE = 10;
    private Node[] storage = new Node[STORAGE_SIZE];
    private K key;
    private V value;
    private int size = 0;

    public StorageImpl() {
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj instanceof Node) {
                Node entry = (Node) obj;

                return key.equals(entry.getKey())
                        && value.equals(entry.getValue());
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

    @Override
    public void put(K key, V value) {
        Node<K, V> entry = new Node<K, V>(key, value, null);
        int index = index(key);

        Node<K, V> existing = storage[index];
        if (existing == null) {
            storage[index] = entry;
            size++;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if ((existing.key == getKey()) || existing.getKey().equals(key)) { //equals?
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }

    }

    @Override
    public V get(K key) {
        Node<K, V> entry = storage[index(key) % STORAGE_SIZE];

        while (entry != null) {
            if ((entry.key == getKey()) || entry.getKey().equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    private int index(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % STORAGE_SIZE);
    }
}
