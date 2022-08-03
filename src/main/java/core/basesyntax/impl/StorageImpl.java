package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private int numberOfElements;
    private StorageNode[] storage;

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
    }

    public StorageImpl() {
        numberOfElements = 0;
        storage = new StorageNode[SIZE];
    }

    @Override
    public void put(K key, V value) {
        boolean rewritten = false;
        for (int i = 0; i < SIZE; i++) {
            if (storage[i] != null) {
                if (storage[i].key != null && storage[i].getKey().equals(key)
                        || storage[i].key == key) {
                    storage[i] = new StorageNode<>(key, value);
                    rewritten = true;
                    break;
                }
            }
        }
        if (!rewritten) {
            for (int i = 0; i < SIZE; i++) {
                if (storage[i] == null) {
                    storage[i] = new StorageNode<>(key, value);
                    numberOfElements++;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (storage[i] != null) {
                if (storage[i].key != null && storage[i].getKey().equals(key)
                        || storage[i].key == key) {
                    return (V) storage[i].value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public K getKey() {
        return (K) storage[size() - 1].key;
    }

    @Override
    public V getValue() {
        return (V) storage[size() - 1].value;
    }
}
