package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private Object[] keys = new Object[SIZE];
    private Object[] values = new Object[SIZE];
    private int arrayIndex = 0;

    @Override
    public void put(K key, V value) {
        if (arrayIndex == 0) {
            addToArray(key, value);
        } else if (arrayIndex < 5) {
            if (!isKeyExist(key, value)) {
                addToArray(key, value);
            }
        } else {
            throw new RuntimeException("You can't add data because array is full!");
        }
    }

    private void addToArray(K key, V value) {
        this.keys[arrayIndex] = key;
        this.values[arrayIndex] = value;
        arrayIndex++;
    }

    private boolean isKeyExist(K key, V value) {
        for (int i = 0; i < arrayIndex; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                this.keys[i] = key;
                this.values[i] = value;
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayIndex; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arrayIndex;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) object;
        boolean isKeysEqual = (keys == null && storage.keys == null)
                || (this.keys != null && Objects.deepEquals(keys, storage.keys));
        boolean isValueEqual = (values == null && storage.values == null)
                || (values != null && Objects.deepEquals(values, storage.values));
        boolean isArrayIndex = arrayIndex == storage.arrayIndex;

        return isArrayIndex
                && isKeysEqual
                && isValueEqual;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (keys == null ? 0 : keys.hashCode());
        result = 31 * result + (values == null ? 0 : values.hashCode());
        result = 31 * result + arrayIndex;
        return result;
    }
}
