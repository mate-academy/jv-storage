package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size = 0;
    
    public StorageImpl() {
        this.keys = new Object[STORAGE_CAPACITY];
        this.values = new Object[STORAGE_CAPACITY];
    }
    
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqual((K) keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        
        keys[size] = key;
        values[size] = value;
        size++;
    }
    
    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqual((K) keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    private boolean isEqual(K firstKey, K secondKey) {
        return firstKey == secondKey
                || (firstKey != null && firstKey.equals(secondKey));
    }
}
