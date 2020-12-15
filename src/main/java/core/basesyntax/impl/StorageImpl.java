package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    
    private K[] keys;
    private V[] values;
    
    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_CAPACITY];
        values = (V[]) new Object[STORAGE_CAPACITY];
    }
    
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && values[i] == null)
                    || key == keys[i] || (key != null && key.equals(keys[i]))) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }
    
    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
