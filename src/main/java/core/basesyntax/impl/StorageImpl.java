package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    @SuppressWarnings("unchecked") private final K[] keyArray = (K[]) new Object[MAX_LENGTH];
    @SuppressWarnings("unchecked") private final V[] valueArray = (V[]) new Object[MAX_LENGTH];
    private int arraySize;
    
    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= arraySize; i++) {
            if ((keyArray[i] == key) && (valueArray[i] != null)) {
                valueArray[i] = value;
                break;
            } else if (keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                break;
            } else if (keyArray[i] == null && valueArray[i] == null) {
                keyArray[arraySize] = key;
                valueArray[arraySize] = value;
                arraySize++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= arraySize; i++) {
            if ((keyArray[i] == key) || (keyArray[i] != null && keyArray[i].equals(key))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public boolean equals(Object storage) {
        if (storage == this) {
            return true;
        }
        if (!(storage.getClass().equals(StorageImpl.class))) {
            return false;
        }

        @SuppressWarnings("unchecked") StorageImpl<K, V> current = (StorageImpl<K, V>)storage;

        //noinspection ConstantConditions
        boolean keyEquals = (this.keyArray == null && current.keyArray == null)
                || (this.keyArray != null && Arrays.equals(this.keyArray, current.keyArray));
        //noinspection ConstantConditions
        boolean valueEquals = (this.valueArray == null && current.valueArray == null)
                || (this.valueArray != null && Arrays.equals(this.valueArray, current.valueArray));

        return keyEquals && valueEquals;
    }
}
