package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 2;
    private static final int NOT_FOUND = -1;
    private static final int SCALE = 2;
    private int capasity;
    private int size;
    private Node<K, V>[] store;

    public StorageImpl() {
        this.size = 0;
        this.capasity = DEFAULT_CAPACITY;
        this.store = new Node[capasity];
    }

    @Override
    public void put(K key, V value) {
        int id = find(key);
        if (id == NOT_FOUND) {
            add(key, value);
            return;
        }
        replace(id, value);
    }

    private void replace(int id, V value) {
        store[id].value = value;
    }

    private void add(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (size >= capasity) {
            Node<K, V>[] tmp = resize();
            copy(tmp, store);
            store = tmp;
        }
        addNewNode(newNode);
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

    private Node<K, V>[] resize() {
        capasity *= SCALE;
        Node<K, V>[] newStore = new Node[capasity];
        return newStore;
    }

    private int find(K key) {
        for (int i = 0; i < size; i++) {
            K curKey = store[i].key;
            if (key == curKey || key != null && key.equals(curKey)) {
                return i;
            }
            if (curKey == null || key == null) {
                continue;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public V get(K key) {
        int index = find(key);
        return index == NOT_FOUND ? null : store[index].value;
    }

    @Override
    public int size() {
        return size;
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
