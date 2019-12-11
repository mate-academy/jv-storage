package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int LENGTH = 10;
    private Node<K,V>[] objects;

    public StorageImpl() {
        this.objects = new Node[LENGTH];
    }

    @Override
    public void put(K key, V value) {

        Node<K, V> node = new Node<>(key, value);

        for (int i = 0; i < LENGTH; i++) {
            if (objects[i] == null) {
                objects[i] = node;
                return;
            } else if (((objects[i]).getKey()  == node.getKey())
                    || (((objects[i]).getKey() != null)
                    && (objects[i]).getKey().equals(node.getKey()))) {
                objects[i] = node;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < LENGTH; i++) {
            
            if (objects[i] != null && ((objects[i]).getKey() == key)
                    || (objects[i] != null && (objects[i]).getKey().equals(key))) {
                return objects[i].getValue();
            }
        }
        return null;
    }

    private static final class Node<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
