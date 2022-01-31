package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_NUMBER = 10;
    private final Node<K, V>[] nodeArray;
    private int size;

    public StorageImpl() {
        nodeArray = new Node[MAX_ARRAY_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == nodeArray[i].getKey() || key != null && key.equals(nodeArray[i].getKey())) {
                nodeArray[i].setValue(value);
                return;
            }
        }

        Node<K, V> pair = new Node<>();
        pair.setKey(key);
        pair.setValue(value);
        nodeArray[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == nodeArray[i].getKey() || key != null && key.equals(nodeArray[i].getKey())) {
                return (V) nodeArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

