package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Node<K, V>[] nodesArray = new Node[10];
    private int size = 0;
    private int indexEqualsKey = 0;

    @Override
    public void put(K key, V value) {

        if (size == 0) {
            nodesArray[size] = getNewNode(key, value);
        } else if (isEqualKey(key)) {
            nodesArray[indexEqualsKey].setValue(value);
            return;
        } else {
            nodesArray[size] = getNewNode(key, value);
        }
        ++size;
    }

    @Override
    public V get(K key) {
        if (isEqualKey(key)) {
            return nodesArray[indexEqualsKey].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEqualKey(K key) {
        for (int index = 0; index < size; ++index) {
            if (nodesArray[index].getKey() == null) {
                if (key == null) {
                    indexEqualsKey = index;
                    return true;
                }
            } else if (nodesArray[index].getKey().equals(key)) {
                indexEqualsKey = index;
                return true;
            }
        }
        return false;
    }

    private Node<K, V> getNewNode(K key, V value) {
        return new Node<>(key, value);
    }
}
