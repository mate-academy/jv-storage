package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int STORAGE_SIZE = 10;
    private Node[] storage = new Node[STORAGE_SIZE];
    private int size;

    public StorageImpl() {
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
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
        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (storage[i] != null) {
                if (storage[i].key != null && storage[i].key.equals(key) || storage[i].key == key) {
                    storage[i] = new Node(key, value);
                    break;
                }
            } else {
                storage[i] = new Node(key, value);
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Node node : storage) {
            if (node != null) {
                if (node.key != null && node.key.equals(key) || node.key == key) {
                    return (V) node.value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
