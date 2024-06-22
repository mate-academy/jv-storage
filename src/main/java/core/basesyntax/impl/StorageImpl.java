package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 5;
    private int size;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        valueArray = (V[])new Object[ARRAY_LENGTH];
        keyArray = (K[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key == null && keyArray[i] == null && valueArray[i] == null) {
                valueArray[i] = value;
                size++;
                return;
            } else if ((key == null && keyArray[i] == null && valueArray[i] != null)
                    || (key != null && key.equals(keyArray[i]))) {
                valueArray[i] = value;
                return;
            }
        }
        if (size < ARRAY_LENGTH) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArray[i] == null) || (key != null && key.equals(keyArray[i]))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StorageImpl<K, V> storage = (StorageImpl<K, V>) obj;
        return (keyArray != null ? Arrays.equals(keyArray, storage.keyArray)
                : storage.keyArray == null)
                && (valueArray != null ? Arrays.equals(valueArray, storage.valueArray)
                : storage.valueArray == null);
    }

    @Override
    public int hashCode() {
        int result = keyArray != null ? Arrays.hashCode(keyArray) : 0;
        return 31 * result + (valueArray != null ? Arrays.hashCode(valueArray) : 0);
    }
}
