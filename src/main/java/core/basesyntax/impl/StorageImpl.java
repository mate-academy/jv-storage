package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ELEMENT = 10;
    private K[] keys = (K[]) new Object[MAX_ELEMENT];
    private V[] values = (V[]) new Object[MAX_ELEMENT];
    private int size;

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (key == null) {
                    if (keys[i] == null) {
                        values[i] = value;
                        return;
                    }
                } else if (key.equals(keys[i])) {
                    values[i] = value;
                    System.out.println(value);
                    return;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return values[i];
                }
            } else if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
