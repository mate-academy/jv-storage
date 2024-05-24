package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int NO_INDEX = -1;
    private static final int SCALE = 2;
    private int size;
    private final Node<K, V>[] store;

    public StorageImpl() {
        this.store = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int id = findIndex(key);
        if (id == NO_INDEX) {
            addNewNode(new Node<>(key, value));
            return;
        }
        replace(id, value);
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

    private void replace(int id, V value) {
        store[id].value = value;
    }

    private void addNewNode(Node<K,V> newNode) {
        store[size] = newNode;
        ++size;
    }

    private void copy(Node<K,V>[] dest, Node<K,V>[] src) {
        for (int i = 0; i < size; i++) {
            dest[i] = src[i];
        }
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            K curKey = store[i].key;
            if (key == curKey || key != null && key.equals(curKey)) {
                return i;
            }
        }
        return NO_INDEX;
    }

    private class Node<K, V> {
        private K key;
        private V value;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
