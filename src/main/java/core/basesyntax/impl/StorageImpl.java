package core.basesyntax.impl;

import core.basesyntax.Node;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DEFAULT_SIZE = 15;
    private static final int RESIZE_COEFFICIENT = 2;
    private Node<K, V>[] nodes;

    public StorageImpl() {
        nodes = new Node[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                nodes[i] = node;
                break;
            }
            if (nodes[i] != null) {
                if (key == nodes[i].getKey()) {
                    nodes[i] = node;
                    break;
                }
                if (nodes[i].getKey() != null && nodes[i].getKey().equals(key)) {
                    nodes[i] = node;
                    break;
                }
                if (i == nodes.length - 1) {
                    Node<K, V>[] buff = nodes;
                    nodes = new Node[nodes.length * RESIZE_COEFFICIENT];
                    System.arraycopy(buff, 0, nodes, 0, buff.length);
                }
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
        int storageSize = 0;
        for (Node<K, V> node : nodes) {
            if (node != null) {
                storageSize++;
            }
        }
        return storageSize;
    }
}
