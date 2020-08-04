package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int STORAGE_CAPACITY = 10;

    private int storageFullness = 0;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[STORAGE_CAPACITY];
        valueArray = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if (i == storageFullness) {
                keyArray[i] = key;
                valueArray[i] = value;
                storageFullness++;
                break;
            } else if (i < storageFullness && ((keyArray[i] == key)
                    || (keyArray[i] != null && keyArray[i].equals(key)))) {
                keyArray[i] = key;
                valueArray[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "StorageImpl{" + "keyArray=" + Arrays.toString(keyArray)
                + ", valueArray=" + Arrays.toString(valueArray) + '}';
    }
}
