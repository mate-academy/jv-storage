package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private V[] items;
    private K[] keys;
    private int size = 0;
    private boolean isEmpty = true;

    @SuppressWarnings({"unchecked"})
    public StorageImpl() {
        items = (V[])new Object[MAX_STORAGE_SIZE];
        keys = (K[])new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (isEmpty) {
            keys[size] = key;
            items[size] = value;
            size++;
            isEmpty = false;
        } else {
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys[i])) {
                    items[i] = value;
                    size--;
                }
            }
            keys[size] = key;
            items[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if(key.equals(keys[i])) {
                return items[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
