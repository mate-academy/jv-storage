package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LIST_LIMIT = 10;
    private V[] storage;
    private K[] keys;
    private int size;

    public StorageImpl() {
        storage = (V[]) new Object[LIST_LIMIT];
        keys = (K[]) new Object[LIST_LIMIT];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == LIST_LIMIT) {
            throw new StorageIsFullException("Storage is full!");
        }
        if (size != 0 && indexOf(key, keys) >= 0) {
            storage[indexOf(key, keys)] = value;
            return;
        }
        storage[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int t = 0; t < size; t++) {
            if (key == null) {
                return storage[indexOf(null, keys)];
            }
            if (key.equals(keys[t])) {
                return storage[t];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int indexOf(Object object, Object[] objects) {
        for (int t = 0; t < objects.length; t++) {
            if (object == null && objects[t] == null) {
                if (storage[t] != null) {
                    return t;
                }
            }
            if ((objects[t] != null && objects[t].equals(object))) {
                return t;
            }
        }
        return -1;
    }
}
