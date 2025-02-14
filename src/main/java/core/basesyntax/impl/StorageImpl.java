package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private int size;

    private class Element<K, V> {
        private K key;
        private V value;
    }

    private Element<K, V>[] storage;

    public StorageImpl() {
        storage = new Element[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = new Element<>();
                storage[i].key = key;
                storage[i].value = value;
                size++;
                break;
            } else if (storage[i].key == key || (storage[i].key != null
                    && storage[i].key.equals(key))) {
                storage[i].value = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storage[i].key == key || (storage[i].key != null
                    && storage[i].key.equals(key))) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
