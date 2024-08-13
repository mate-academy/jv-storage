package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private static final int NULL_KEY_INDEX = 0;
    private final Node<K, V>[] table;
    private int size;

    public StorageImpl() {
        this.table = new Node[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByHashCode(key);
        Node<K, V> newNode = new Node<>(key, value);
        if (table[index] == null) {
            table[index] = newNode;
            size++;
            return;
        }
        Node<K, V> currentNode = table[index];
        while (currentNode.hasNext()) {
            if (keyAndNodeKeyEquals(key, currentNode)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        if (keyAndNodeKeyEquals(key, currentNode)) {
            currentNode.value = value;
            return;
        }
        currentNode.next = newNode;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndexByHashCode(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (keyAndNodeKeyEquals(key, node)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    private boolean keyAndNodeKeyEquals(K key, Node<K, V> node) {
        return (node.key == null && key == null) || (node.key != null && node.key.equals(key));
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByHashCode(K key) {
        return key == null ? NULL_KEY_INDEX : Math.abs(key.hashCode() % table.length);
    }

    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
