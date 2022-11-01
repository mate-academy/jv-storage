package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[MAX_NUMBER];
        values = new Object[MAX_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equalsKey(key, (K) keys[i])) {
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
            if (equalsKey(key, (K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean equalsKey(K firstKey, K secondKey) {
        if ((firstKey == secondKey) || ((firstKey != null) && firstKey.equals(secondKey))) {
            return true;
        }
        return false;
    }
}
