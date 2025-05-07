package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private StorageNode<K, V>[] items;
    private int size = 0;

    public StorageImpl() {
        items = new StorageNode[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int position = findPositions(key);
        items[position] = new StorageNode<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (isKeyAtIndexEqualTo(i, key)) {
                return items[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findPositions(K key) {
        for (int i = 0; i < size(); i++) {
            if (isKeyAtIndexEqualTo(i, key)) {
                size--;
                return i;
            }
        }
        return size();
    }

    private boolean isKeyAtIndexEqualTo(int index, K key) {
        StorageNode<K,V> node = (StorageNode) items[index];
        return node.getKey() == key || (node.getKey() != null && node.getKey().equals(key));
    }

    private class StorageNode<K, V> {
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
}
