package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private final Node<K, V>[] nodeArray = new Node[MAX_NUMBER_OF_ELEMENTS];
    private int size = 0;

    private int getIndex(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (key == nodeArray[i].key
                || nodeArray[i].key != null && nodeArray[i].key.equals(key)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            nodeArray[index].value = value;
            return;
        }
        nodeArray[size] = new Node<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        V value = null;
        int index = getIndex(key);
        if (index != -1) {
            value = nodeArray[index].value;
        }
        return value;
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
