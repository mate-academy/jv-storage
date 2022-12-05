package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = getPosition(key);
        if (keyPosition == -1) {
            if (size < MAX_ITEMS_NUMBER) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                System.out.println("Storage is full!");
            }
        } else {
            values[keyPosition] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyPosition = getPosition(key);
        if (keyPosition == -1) {
            return null;
        }
        return values[keyPosition];
    }

    @Override
    public int size() {
        return size;
    }

    private int getPosition(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
