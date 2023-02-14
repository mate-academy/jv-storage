package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAXIMUM_CAPACITY];
        valueArray = (V[]) new Object[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAXIMUM_CAPACITY; i++) {
            if ((keyArray[i] == valueArray[i])
                    || (keyArray[i] == key)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                keyArray[i] = key;
                valueArray[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAXIMUM_CAPACITY; i++) {
            if ((keyArray[i] == key) || (Objects.equals(keyArray[i], key))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAXIMUM_CAPACITY; i++) {
            if (keyArray[i] == valueArray[i]) {
                return i;
            }
        }
        return 0;
    }
}
