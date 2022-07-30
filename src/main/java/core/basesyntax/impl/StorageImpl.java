package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] items = new Object[MAX_ITEMS_NUMBER];
    private K key;
    private V value;
    private int size;
    private int findKey = -1;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        get(key);
        if (findKey >= 0) {
            size--;
        } 
        items[size] = new Object[]{key,value};
        size++;
    }

    @Override
    public V get(K key) {
        for (Object item: items) {
            if (item != null) {
                Object[] tmp = (Object[]) item;
                if (key != null && key.equals(tmp[0])) {
                    findKey++;
                    return (V) tmp[1];
                }
                if (key == tmp[0]) {
                    findKey++;
                    return (V) tmp[1];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StorageImpl<K, V> storage = (StorageImpl<K, V>) obj;
        return (storage.getKey() == key
                || (storage.getKey() != null
                && storage.getKey().equals(key)))
                && (storage.getValue() == value
                || (storage.getValue() != null
                && storage.getValue().equals(value)));
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode() << 16)
                & (value == null ? 0 : value.hashCode());
    }
}
