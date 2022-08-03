package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE_ARRAY = 10;
    private K key;
    private V value;
    private Object[] items = new Object[MAX_VALUE_ARRAY];
    private int countOfElements = 0;

    private class StorageNode {
        private K key;
        private V value;

        public StorageNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        int position = findPositions(key);
        items[position] = new StorageNode(key, value);
        countOfElements++;
    }

    @Override
    public V get(K key) {
        int position = -1;
        for (int i = 0; i < size(); i++) {
            if (checkElementInside(i, key)) {
                position = i;
            }
        }
        if (position == -1) {
            return null;
        }
        StorageNode castedElement = (StorageNode) items[position];
        return castedElement.getValue();
    }

    @Override
    public int size() {
        return countOfElements;
    }

    private int findPositions(K key) {
        for (int i = 0; i < size(); i++) {
            if (checkElementInside(i, key)) {
                countOfElements--;
                return i;
            }
        }
        return size();
    }

    private boolean checkElementInside(int index, K key) {
        StorageNode castedElement = (StorageNode) items[index];
        return (castedElement.getKey() == null && key == null)
                || (castedElement.getKey() == key)
                || (castedElement.getKey() != null) && castedElement.getKey().equals(key);
    }
}
