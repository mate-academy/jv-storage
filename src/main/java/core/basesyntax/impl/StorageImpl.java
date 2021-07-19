package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_LENGTH = 10;
    @SuppressWarnings("unchecked") private final K[] keyArray = (K[]) new Object[ARRAY_LENGTH];
    @SuppressWarnings("unchecked") private final V[] valueArray = (V[]) new Object[ARRAY_LENGTH];
    public static int arraySize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(keyArray[i], key)) {
                valueArray[i] = value;
                break;
            } else if (keyArray[i] == null && valueArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                arraySize++;
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
