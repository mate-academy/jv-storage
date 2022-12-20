package core.basesyntax.impl;

import core.basesyntax.Node;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final int RESIZE_COEFFICIENT = 2;
    private int storageSize;
    private Node<K, V>[] nodes;

    public StorageImpl() {
        nodes = new Node[DEFAULT_INITIAL_CAPACITY];
        storageSize = 0;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                nodes[i] = node;
                storageSize++;
                break;
            } else if (key == nodes[i].getKey() || (nodes[i].getKey() != null
                    && nodes[i].getKey().equals(key))) {
                nodes[i] = node;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Node node : nodes) {
            if (node != null) {
                if (key == node.getKey()) {
                    return (V) node.getValue();
                }
                if (node.getKey() != null) {
                    if (node.getKey().equals(key)) {
                        return (V) node.getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
