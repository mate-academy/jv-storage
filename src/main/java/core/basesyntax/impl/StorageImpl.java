package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final Node<K, V>[] data;
    private int size;

    public StorageImpl() {
        data = new Node[STORAGE_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = getNodeByKey(key);
        if (node != null) {
            node.setValue(value);
            return;
        }
        data[size] = new Node<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNodeByKey(key);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<K, V> getNodeByKey(K key) {
        for (int i = 0; i < size; i++) {
            Node<K, V> node = data[i];
            if (node.getKey() == key || node.getKey() != null && node.getKey().equals(key)) {
                return node;
            }
        }
        return null;
    }
}
