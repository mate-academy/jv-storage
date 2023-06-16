package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (containsKey(null)) {
                putValue(null, value);
            } else {
                if (size < MAX_SIZE) {
                    putValue(null, value);
                    size++;
                } else {
                    throw new IllegalStateException("Storage is full");
                }
            }
        } else {
            if (containsKey(key)) {
                putValue(key, value);
            } else {
                if (size < MAX_SIZE) {
                    putValue(key, value);
                    size++;
                } else {
                    throw new IllegalStateException("Storage is full");
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null ? key == null : keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null ? key == null : keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    private void putValue(Object key, Object value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null ? key == null : keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StorageImpl<?, ?> other = (StorageImpl<?, ?>) obj;
        return arrayEquals(keys, other.keys)
                && arrayEquals(values, other.values)
                && size == other.size;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + arrayHashCode(keys);
        result = 31 * result + arrayHashCode(values);
        result = 31 * result + size;
        return result;
    }

    private boolean arrayEquals(Object[] arr1, Object[] arr2) {
        if (arr1 == arr2) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == null ? arr2[i] != null : !arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    private int arrayHashCode(Object[] arr) {
        if (arr == null) {
            return 0;
        }
        int result = 1;
        for (Object element : arr) {
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }
        return result;
    }
}
