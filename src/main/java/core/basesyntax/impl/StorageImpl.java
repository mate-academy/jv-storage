package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];
    private int size;


    public int getSize() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        int index = putValidator(getKeys(), getValues(), key);
        if (index == -1) {
            getKeys()[getSize()] = key;
            getValues()[getSize()] = value;
            grow();
        } else if (index >= 0) {
            getKeys()[index] = key;
            getValues()[index] = value;
        }
    }

    @Override
    public V get(K key) {
        return getValidator(getKeys(), getValues(), key);
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
                return i;
        }
        return -1;
    }

    private V getValidator(K[] keys, V[] values, K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    private void grow() {
        size++;
    }
}

