package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int lastIndexOfArray = 0;
    private int index = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (key != null) {
            if (lastIndexOfArray == 0) {
                saveStorage(key, value);
            } else if (isKey(key)) {
                values[index] = value;
            } else {
                saveStorage(key, value);
            }
            index = 0;
        } else {
            saveStorage(null, value);
        }
    }

    @Override
    public V get(K key) {
        for (; index < lastIndexOfArray; index++) {
            if (isKey(key)) {
                return values[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lastIndexOfArray;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (keys[index] != null) {
            return 31 * result + keys[index].hashCode();
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
        return obj.hashCode() == keys[index].hashCode();
    }

    public boolean isKey(K key) {
        if (key != null) {
            for (;index < lastIndexOfArray; index++) {
                if (keys[index] != null) {
                    if (keys[index].equals(key)) {
                        return true;
                    }
                }
            }
        } else {
            for (;index < lastIndexOfArray; index++) {
                if (keys[index] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void saveStorage(K key, V value) {
        keys[lastIndexOfArray] = key;
        values[lastIndexOfArray] = value;
        lastIndexOfArray++;
    }
}
