package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int maxSize = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[maxSize];
        this.values = (V[]) new Object[maxSize];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equalsKey((keys[i]), key)) {
                values[i] = value;
                return;
            }
        }
        if (size >= maxSize) {
            throw new IllegalStateException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (equalsKey((keys[i]), key)) {
                return values[i];
            }
        }
        return null;
    }

    private boolean equalsKey(K key, Object object) {
        if (key == object) {
            return true;
        }
        if (object == null || key == null || !key.getClass().equals(object.getClass())) {
            return false;
        }
        K secondKey = (K) object;
        return key.equals(secondKey);
    }

    @Override
    public int size() {
        return size;
    }
}
