package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private Pair<K,V>[] data;
    private int size;
    
    @SuppressWarnings("unchecked")
    public StorageImpl() {
        data = new Pair[INITIAL_CAPACITY];
        size = 0;
    }
    
    private boolean keysEqual(K a, K b) {
        return a == b || (a != null && a.equals(b));
    }
    
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(key,data[i].getKey())) {
                data[i].setValue(value);
                return;
            }
        }
        data[size++] = new Pair<>(key,value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(key,data[i].getKey())) {
                return data[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

