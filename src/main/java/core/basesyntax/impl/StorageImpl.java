package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private V[] items;
    private K[] keys;
    private int size = 0;

    @SuppressWarnings({"unchecked"})
    public StorageImpl() {
        items = (V[]) new Object[MAX_STORAGE_SIZE];
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (!keyValidator(key, value)) {
            keys[size] = key;
            items[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null)
                    || key != null && key.equals(keys[i])) {
                return items[i];
            }
        }
        return null;
    }

    //i don't wanna use cycle for finding my storage length.
    //So i just add counter to my put method.
    @Override
    public int size() {
        return size;
    }

    private boolean keyValidator(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null)
                    || key != null && key.equals(keys[i])) {
                items[i] = value;
                return true;
            }
        }
        return false;
    }
}
