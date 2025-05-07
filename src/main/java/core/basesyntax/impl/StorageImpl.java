package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_ARRAY_SIZE];
        this.valueArray = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    private boolean keysEqual(K keyFirst, K keySecond) {
        return keyFirst == keySecond || (keyFirst != null && keyFirst.equals(keySecond));
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(key, keyArray[i])) {
                this.valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (keysEqual(key, keyArray[i])) {
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
