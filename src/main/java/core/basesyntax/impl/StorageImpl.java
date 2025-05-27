package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private final Node<K, V>[] table = new Node[INITIAL_CAPACITY];
    private int size;

    @Override
    public void put(K key, V value) {
        Node<K, V> node = getNode(key);
        if (node == null && size() < INITIAL_CAPACITY - 1) {
            table[size++] = new Node<>(key, value);
        } else {
            node.setValue(value);
        }
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    private Node<K, V> getNode(K key) {
        for (Node<K, V> node : table) {
            if (node != null && (key == null ? node.getKey() == null : key.equals(node.getKey()))) {
                return node;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
