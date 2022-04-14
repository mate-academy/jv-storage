package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = new K(MAX_CAPACITY);
        values = new V[MAX_CAPACITY];
    }
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < 10; i++) {
            if (keys[i] == null & values[i] == null) {
                keys[i] = key;
                values[i] = value;
            }
        }
    }
    @Override
    public V get(K key) {
        for (int i = 0; i < 10; i++) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }
    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (keys[i] != null & values[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
