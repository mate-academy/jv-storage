package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 10;
    Node<K, V>[] nodes;
    int size;

    public StorageImpl() {
        this.nodes = new Node[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean valueAdded = false;

        for (Node node : nodes) {
            if (node != null && node.getKey() != null && node.getKey().equals(key)) {
                node.setValue(value);
                valueAdded = true;
                break;
            }
        }

        if (!valueAdded) {
            nodes[size++] = new Node(key, value);
        }
    }

    @Override
    public V get(K key) {
        V result = null;

        for (Node node : nodes) {
            if (node != null
                    && (node.getKey() == null && key == null
                    || node.getKey() != null && node.getKey().equals(key))) {
                result = (V) node.getValue();
                break;
            }
        }
        return result;
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



































