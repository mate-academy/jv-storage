package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Node[] elements;
    private int size;

    public StorageImpl() {
        elements = new Node[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].getKey() == key
                    || elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                elements[i].setValue(value);
                return;
            }
        }
        Node element = new Node(key, value);
        elements[size] = element;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (elements[i].getKey() == key
                    || elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                return (V) elements[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public Node[] getElements() {
        return elements;
    }

    public void setElements(Node[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
