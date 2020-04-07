package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Node<K, V>[] nodes;
    private int size;

    public StorageImpl() {
        this.nodes = new Node[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {

        for (Node node : nodes) {
            if (node != null && node.getKey() != null && node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        nodes[size++] = new Node(key, value);
    }

    @Override
    public V get(K key) {

        for (Node node : nodes) {
            if (node != null
                    && (node.getKey() == null && key == null
                    || node.getKey() != null && node.getKey().equals(key))) {
                return (V) node.getValue();
            }
        }
        return null;
    }

    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
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
