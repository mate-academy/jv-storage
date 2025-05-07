package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private StorageNode<K, V>[] data;

    private class StorageNode<K, V> {
        private K key;
        private V value;

        public StorageNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public StorageImpl() {
        size = 0;
        data = new StorageNode[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (data[i].key != null && data[i].key.equals(key) || data[i].key == key) {
                data[i] = new StorageNode<>(key, value);
                return;
            }
        }
        data[size] = new StorageNode<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (data[i].key != null && data[i].key.equals(key)
                    || data[i].key == key) {
                return data[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public K getKey() {
        return (K) data[size() - 1].key;
    }

    @Override
    public V getValue() {
        return (V) data[size() - 1].value;
    }
}
