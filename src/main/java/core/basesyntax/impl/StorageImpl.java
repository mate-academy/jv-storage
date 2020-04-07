package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private Node<K, V>[] nodes;
    private int checker;

    public StorageImpl() {
        checker = 0;
        nodes = new Node[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < checker; i++) {
            if ((key == nodes[i].key)
                    || (nodes[i].key != null && nodes[i].key.equals(key))) {
                nodes[i].value = value;
                return;
            }
        }
        nodes[checker] = new Node<K, V>();
        nodes[checker].key = key;
        nodes[checker].value = value;
        checker++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < checker; i++) {
            if ((key == nodes[i].key)
                    || (nodes[i].key != null && nodes[i].key.equals(key))) {
                return nodes[i].value;
            }
        }
        return null;
    }

    private class Node<K, V> {
        private K key;
        private V value;
    }

}
