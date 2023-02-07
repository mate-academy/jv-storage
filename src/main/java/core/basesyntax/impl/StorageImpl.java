package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int index = 0;
    private K key;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (keys.length > 0) {
            for (int i = 0; i < size(); i++) {
                this.key = keys[i];
                if (this.key.equals(key)) {
                    values[i] = value;
                } else {
                    saveStorage(key, value);
                }
            }
        } else {
            saveStorage(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (isKey(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.length;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (key != null) {
            return 31 * result + key.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if ((obj instanceof StorageImpl)) {
            return false;
        }
        return obj.hashCode() == key.hashCode();
    }

    public boolean isKey(K key) {
        if (key != null) {
            for (int i = 0; i < size(); i++) {
                this.key = keys[i];
                if (this.key != null) {
                    if (this.key.equals(key)) {
                        return true;
                    }
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                this.key = keys[i];
                if (this.key == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void saveStorage(K key, V value) {
        keys[index] = key;
        values[index] = value;
        index++;
    }
}
