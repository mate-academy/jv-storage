package core.basesyntax.impl;

import core.basesyntax.Storage;


public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;

    protected K[] keys = (K[]) new Object[MAX_SIZE];
    protected V[] values = (V[]) new Object[MAX_SIZE];
    private int size;

    public StorageImpl() {
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (keys[i] != null && keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            }
        }

        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println("Storage is full, cannot add more elements.");
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (keys[i] != null && keys[i].equals(key)) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
