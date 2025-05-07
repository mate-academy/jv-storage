package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_ARRAY_NODES = 10;
    private final Node<K, V>[] nodesArray;
    private int size;

    public StorageImpl() {
        nodesArray = new Node[SIZE_ARRAY_NODES];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int index = 0; index < size; ++index) {
            if (isEqualKey(key, nodesArray[index].getKey())) {
                nodesArray[index].setValue(value);
                return;
            }
        }
        nodesArray[size] = getNewNode(key, value);
        ++size;
    }

    @Override
    public V get(K key) {
        for (int index = 0; index < size; ++index) {
            if (isEqualKey(key, nodesArray[index].getKey())) {
                return nodesArray[index].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEqualKey(K key, K nodeKey) {
        return nodeKey == key || nodeKey != null && nodeKey.equals(key);
    }

    private Node<K, V> getNewNode(K key, V value) {
        return new Node<>(key, value);
    }
}
