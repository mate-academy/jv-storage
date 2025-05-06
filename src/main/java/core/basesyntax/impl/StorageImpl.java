package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int NO_INDEX = -1;
    private int size;
    private final Node<K, V>[] store;

    public StorageImpl() {
        store = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index == NO_INDEX) {
            addNewNode(new Node<>(key, value));
            return;
        }
        store[index].value = value;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index == NO_INDEX ? null : store[index].value;
    }

    @Override
    public int size() {
        return size;
    }

    private void addNewNode(Node<K,V> newNode) {
        store[size] = newNode;
        ++size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = store[i].key;
            if (key == currentKey || key != null && key.equals(currentKey)) {
                return i;
            }
        }
        return NO_INDEX;
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
