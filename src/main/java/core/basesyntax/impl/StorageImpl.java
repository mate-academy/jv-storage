package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Node head;
    private Node curNode;
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (head == null) {
            head = new Node(key, value);
        } else {
            curNode = head;
            while (curNode.nextNode != null) {
                if ((compareKeys(key, curNode.key))
                        || curNode.key != null && curNode.key.equals(key)) {
                    curNode.value = value;
                    return;
                }
                curNode = curNode.nextNode;
            }
            if (compareKeys(key, curNode.key)) {
                curNode.value = value;
                return;
            }
            curNode.nextNode = new Node(key, value);
        }
        size++;
    }

    @Override
    public V get(K key) {
        curNode = head;
        while (curNode != null) {
            if (compareKeys(key, curNode.key)) {
                return curNode.value;
            }
            curNode = curNode.nextNode;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareKeys(K keyFromParameters, K curNodeKey) {
        if (keyFromParameters == null && curNodeKey == null) {
            return true;
        }
        return (keyFromParameters != null && curNodeKey != null)
                && keyFromParameters.equals(curNodeKey);
    }

    private class Node {
        private K key;
        private V value;
        private Node nextNode;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nextNode = null;
        }
    }
}
