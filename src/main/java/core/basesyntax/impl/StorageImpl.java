package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    @SuppressWarnings("unchecked") private final K[] keyArray = (K[]) new Object[10];
    @SuppressWarnings("unchecked") private final V[] valueArray = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == null && valueArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < valueArray.length; i++) {
            if (keyArray[i] == key) {
                result = valueArray[i];
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < valueArray.length; i++) {
            if ((valueArray[i] != null) || (keyArray[i] != null)) {
                result++;
            }
        }
        return result;
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
                || (Arrays.equals(this.keyArray, current.keyArray));
        //noinspection ConstantConditions
        boolean valueEquals = (this.valueArray == null && current.valueArray == null)
                || (Arrays.equals(this.valueArray, current.valueArray));

        return keyEquals && valueEquals;
    }
}
