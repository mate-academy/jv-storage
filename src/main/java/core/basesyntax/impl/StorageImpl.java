package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE = 10;
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
            if (Objects.equals(key, currentNode.key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        if (Objects.equals(key, currentNode.key)) {
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
            if (Objects.equals(key, node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByHashCode(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
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
