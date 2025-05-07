package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int count;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (count < 10) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            System.out.println("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
