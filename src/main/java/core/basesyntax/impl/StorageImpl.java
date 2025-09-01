package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_CAPACITY = 10;
    private Node<K, V>[] nodes;
    private int size;

    public StorageImpl() {
        nodes = new Node[MAX_CAPACITY];
        size = 0;
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            Node<K, V> current = nodes[i];
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }
            if (size >= nodes.length) {
                throw new RuntimeException("Storage is full, cannot add new key");
            }
        }
        if (size >= nodes.length) {
            throw new RuntimeException("Storage is full, cannot add new key");
        }
        nodes[size] = new Node(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Node<K, V> current = nodes[i];
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
