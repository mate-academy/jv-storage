package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_ARRAY = 10;
    private int count = 0;
    private K key;
    private V value;
    private StorageImpl[] mas = new StorageImpl[MAX_ARRAY];
    
    @Override
    public void put(K key, V value) {
        StorageImpl<K, V> storage = new StorageImpl<>();
        storage.key = key;
        storage.value = value;
       
        if (!isIn(key)) {
            mas[count] = storage;
            count++;
        }
        if (isIn(key)) {
            changeValue(key, value);
        }
    }
    
    @Override
    public V get(K key) {
        
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == null) {
                continue;
            }
            if (key != null) {
                if (key.equals(mas[i].key)) {
                    value = (V) mas[i].value;
                }
            } else {
                if (key == (mas[i].key)) {
                    value = (V) mas[i].value;
                }
            }
        }
        return value;
    }
    
    @Override
    public int size() {
        return count;
    }
    
    public boolean isIn(K key) {
        for (StorageImpl storage : mas) {
            if (storage == null) {
                continue;
            }
            if (key != null) {
                if (key.equals(storage.key)) {
                    return true;
                }
            } else {
                if (key == (storage.key)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void changeValue(K key, V value) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == null) {
                continue;
            }
            if (key != null) {
                if (key.equals(mas[i].key)) {
                    mas[i].value = value;
                }
            } else {
                if (key == (mas[i].key)) {
                    mas[i].value = value;
                }
            }
        }
    }
}
