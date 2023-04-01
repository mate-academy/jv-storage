package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private final Node<K, V>[] nodeArray;
    private int size;

    public StorageImpl() {
        nodeArray = new Node[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            nodeArray[index].value = value;
            return;
        }
        nodeArray[size++] = new Node<>(key, value);
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return nodeArray[index].value;
        }
        return null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == nodeArray[i].key
                    || nodeArray[i].key != null && nodeArray[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private final K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
