package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private StorageNode[] storage;
    //private K key;
    //private V value;

    private class StorageNode <K, V> {
        private K key;
        private V value;

        public StorageNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public StorageImpl() {
        storage = new StorageNode[SIZE];
        //key = null;
        //value = null;
    }

    /*
    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }
     */

    @Override
    public void put(K key, V value) {
        boolean rewritten = false;
        for (int i = 0; i < SIZE; i++) {
            if (storage[i] != null) {
                if (storage[i].getKey() != null && storage[i].getKey().equals(key)
                        || storage[i].getKey() == key) {
                    storage[i] = new StorageImpl<>(key, value);
                    rewritten = true;
                    break;
                }
            }
        }
        if (!rewritten) {
            for (int i = 0; i < SIZE; i++) {
                if (storage[i] == null) {
                    storage[i] = new StorageImpl<>(key, value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (storage[i] != null) {
                if (storage[i].getKey() != null && storage[i].getKey().equals(key)
                        || storage[i].getKey() == key) {
                    return (V) storage[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (Storage element : storage) {
            if (element == null) {
                break;
            }
            counter++;
        }
        return counter;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
