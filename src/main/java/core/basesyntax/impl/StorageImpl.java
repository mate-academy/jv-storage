package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private final Object[] keys = new Object[MAX_LENGTH];
    private final Object[] values = new Object[MAX_LENGTH];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEquel(keys[i], key)) {
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
        for (int i = 0; i < keys.length; i++) {
            if (isEquel(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEquel(Object firstObject, Object secondObject) {
        if (firstObject == secondObject || firstObject != null
                && firstObject.equals(secondObject)) {
            return true;
        }
        return false;
    }
}
