package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size = 0;
    private Object[] keySet;
    private Object[] valueSet;
    private StorageImpl<K, V> storageImpl;

    public StorageImpl() {
        keySet = new Object[CAPACITY];
        valueSet = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            storageImpl = new StorageImpl<>();
            keySet[size] = key;
            valueSet[size] = value;
            size++;
        } else if (Arrays.asList(keySet).contains(key)
                && Arrays.asList(keySet).indexOf(key) <= size - 1) {
            valueSet[Arrays.asList(keySet).indexOf(key)] = value;
        } else {
            keySet[size] = key;
            valueSet[size] = value;
            size++;
        }
        if (key == null) {
            valueSet[Arrays.asList(keySet).indexOf(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (Arrays.asList(keySet).contains(key)) {
            return (V) valueSet[Arrays.asList(keySet).indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
