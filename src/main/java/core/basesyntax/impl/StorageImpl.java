package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    Node<K, V>[] nodes;
    int checker;

    public StorageImpl() {
        checker = -1;
        nodes = new Node[10];
    }

    @Override
    public void put(K key, V value) {
        if (key != null) {
            if (checker == -1) {
                checker++;
                nodes[checker] = new Node<K, V>();
                nodes[checker].key = key;
                nodes[checker].value = value;
            } else {
                boolean revrite = true;
                for (int i = 0; i < checker + 1; i++) {
                    if (nodes[i].key != null && nodes[i].key.equals(key)) {
                        nodes[i].value = value;
                        revrite = false;
                    }
                }
                if (revrite) {
                    checker++;
                    nodes[checker] = new Node<K, V>();
                    nodes[checker].key = key;
                    nodes[checker].value = value;
                }
            }
        } else if (checker == -1) {
            checker++;
            nodes[checker] = new Node<K, V>();
            nodes[checker].key = null;
            nodes[checker].value = value;
        } else {
            boolean revrite = true;
            for (int i = 0; i < checker + 1; i++) {
                if (nodes[i].key == null) {
                    nodes[i].value = value;
                    revrite = false;
                }
            }
            if (revrite) {
                checker++;
                nodes[checker] = new Node<K, V>();
                nodes[checker].key = null;
                nodes[checker].value = value;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < checker + 1; i++) {
                if (nodes[i].key == null) {
                    return nodes[i].value;
                }
            }
        } else {
            for (int i = 0; i < checker + 1; i++) {
                if (nodes[i].key != null && nodes[i].key.equals(key)) {
                    return nodes[i].value;
                }
            }
        }
        return null;
    }

    private class Node<K, V> {
        private K key;
        private V value;
    }

}
