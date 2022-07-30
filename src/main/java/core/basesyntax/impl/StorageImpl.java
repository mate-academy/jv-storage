package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] items = new Object[MAX_ITEMS_NUMBER];
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
        findByKey(key);
        if (findKey >= 0) {
            items[findKey] = new Object[]{key, value};
            size--;
        }
        items[size] = new Object[]{key,value};
        size++;
    }

    public Object findByKey(K key) {
        for (int i = 0; i < size; i++) {
            Object[] tmp = (Object[]) items[i];
            if (key != null && key.equals(tmp[0])) {
                findKey = i;
                return tmp[1];
            }
            if (key == null && key == tmp[0]) {
                findKey = i;
                return tmp[1];
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        return (V) findByKey(key);
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
