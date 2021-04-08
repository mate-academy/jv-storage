package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_NUMBER = 10;
    private int size;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_NUMBER];
        this.valueArray = (V[]) new Object[MAX_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

