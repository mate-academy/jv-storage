package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int CAPACITY = 10;

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

            Node<K, V> pair = (Node) o;

            if (key != null ? !key.equals(pair.key) : pair.key != null) {
                return false;
            }
            return value != null ? value.equals(pair.value) : pair.value == null;
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

    Node<K, V>[] nodes = new Node[CAPACITY];
    int size = 0;

    @Override
    public void put(K key, V value) {
        boolean isNodeWasRewritten = false;

        for (Node node : nodes) {
            if (node != null && node.getKey() != null && node.getKey().equals(key)) {
                node.setValue(value);
                isNodeWasRewritten = true;
                break;
            }
        }

        if (!isNodeWasRewritten) {
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
}
