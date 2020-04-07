package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Node<K, V>[] nodes;
    private int checker;

    public StorageImpl() {
        checker = -1;
        nodes = new Node[10];
    }

    @Override
    public void put(K key, V value) {
        if (checker == -1) {
            checker++;
            nodes[checker] = new Node<K, V>();
            nodes[checker].key = key;
            nodes[checker].value = value;
        } else {
            boolean notRewrited = true;
            for (int i = 0; i < checker + 1; i++) {
                if ((key == null && nodes[i].key == null)
                        || (nodes[i].key != null && nodes[i].key.equals(key))) {
                    nodes[i].value = value;
                    notRewrited = false;
                }
            }
            if (notRewrited) {
                checker++;
                nodes[checker] = new Node<K, V>();
                nodes[checker].key = key;
                nodes[checker].value = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < checker + 1; i++) {
            if ((key == null && nodes[i].key == null)
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
