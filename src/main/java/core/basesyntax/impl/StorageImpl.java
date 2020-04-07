package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int CAPACITY = 10;
    private Node<K, V>[] nodes;
    private int size;

    public StorageImpl() {
        nodes = new Node[CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (Node node : nodes) {
            if (node != null
                    && (key == null && node.getKey() == null
                    || node.getKey() != null && node.getKey().equals(key))) {
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
                    && (key == null && node.getKey() == null
                    || node.getKey() != null && node.getKey().equals(key))) {
                return (V) node.getValue();
            }
        }
        return null;
    }

    class Node<K, V> {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<K, V> node = (Node) o;

            return (node.value == value || (value != null && value.equals(node.value)))
                    && (node.key == key || (key != null && key.equals(node.key)));
        }

        @Override
        public int hashCode() {
            int result = 17;
            if (key != null) {
                result = 19 * result + key.hashCode();
            }
            if (value != null) {
                result = 23 * result + value.hashCode();
            }
            return result;
        }
    }
}
