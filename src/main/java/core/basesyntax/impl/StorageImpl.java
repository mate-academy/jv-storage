package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int SIZE = 10;
    private static Node[] collection = new Node[SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < collection.length; ++i) {
            if (collection[i] == null || collection[i].key == key) {
                collection[i] = new Node<>(key, value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < collection.length; ++i) {
            if (collection[i] != null
                    && (collection[i].key == key
                    || collection[i].key.equals(key))) {
                return (V) collection[i].value;
            }
        }
        return null;
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
