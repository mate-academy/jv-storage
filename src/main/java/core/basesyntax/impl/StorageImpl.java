package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[ARRAY_SIZE];
        this.valueArray = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEquals(keyArray[i], key)) {
                valueArray[i] = value;
                if (i == 0 && size == 0) {
                    size++;
                }
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
            if (isEquals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEquals(K firstKey, K secondKey) {
        if (firstKey == secondKey || (firstKey != null && firstKey.equals(secondKey))) {
            return true;
        }
        return false;
    }
}
