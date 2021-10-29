package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_ITEMS_NUMBER) {
            System.out.println("Storage is full");
            return;
        }
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
        }
        if (key != null) {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[size] = key;
        values[size] = value;
        this.size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getWhenKeyIsNull();
        } else {
            return getWhenKeyIsNotNull(key);
        }
    }

    private V getWhenKeyIsNull() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }

    private V getWhenKeyIsNotNull(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

}
