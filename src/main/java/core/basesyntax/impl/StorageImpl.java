package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    public static final int HASH_RESULT = 17;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object storage) {
        if (storage == this) {
            return true;
        }
        if (storage == null) {
            return false;
        }
        if (storage.getClass().equals(StorageImpl.class)) {
            StorageImpl current = (StorageImpl) storage;
            return (keys != null ? this.keys.equals(current.keys)
                    : current.keys == null)
                    && (values != null ? this.values.equals(current.values)
                    : current.values == null);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = HASH_RESULT;
        result = HASH_RESULT * result + (keys == null ? 0 : keys.hashCode());
        result = HASH_RESULT * result + (values == null ? 0 : values.hashCode());
        return result;
    }
}
