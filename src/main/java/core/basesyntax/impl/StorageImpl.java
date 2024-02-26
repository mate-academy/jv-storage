package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;
    private int result;
    private boolean keyFound;

    public StorageImpl() {
        this.keys = new Object[ARRAY_MAX_SIZE];
        this.values = new Object[ARRAY_MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size < ARRAY_MAX_SIZE) {
            keyFound = false;
            for (int i = 0; i < size; i++) {
                if (keys[i] == null ? key == null : keys[i].equals(key)) {
                    values[i] = value;
                    keyFound = true;
                    break;
                }
            }
            if (!keyFound) {
                keys[size] = key;
                values[size] = value;
                size();
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return (V) values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size++;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        StorageImpl<K, V> storageImpl = (StorageImpl<K, V>) object;
        return (keys == null
                ? storageImpl.keys == null
                : keys.equals(storageImpl.keys))
                && (values == null
                ? storageImpl.values == null
                : values.equals(storageImpl.values));
    }

    public int hashCode() {
        result = 17;
        result = 31 * result + (keys != null ? keys.hashCode() : 0);
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }
}
