package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        try {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (key == null && keys[i] == key || (keys[i] == null && values[i] == null)) {
                    keys[i] = key;
                    if (values[i] == null) {
                        size++;
                    }
                    values[i] = value;
                    return;
                }
                if (keys[i] != null && keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public V get(K key) {
        try {
            for (int i = 0; i < size; i++) {
                if (keys[i] != null && keys[i].equals(key) || key == keys[i]) {
                    return values[i];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
