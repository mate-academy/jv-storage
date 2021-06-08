package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = 0;
        for (Object currentKey : keys) {
            if (key == currentKey || (key != null && key.equals(currentKey)) 
                    || (key != null && index == size)) {
                values[index] = value;
                if (size <= index) {
                    keys[index] = key;
                    size++;
                }
                return;
            }
            index++;
        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (Object currentKey : keys) {
            if (currentKey == key || (key != null && key.equals(currentKey))) {
                return values[index];
            }
            index++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
