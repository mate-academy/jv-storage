package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    private int size;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_ELEMENTS];
        this.valueArray = (V[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || key != null && key.equals(keyArray[i])) {
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
        V value = null;
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || key != null && key.equals(keyArray[i])) {
                value = valueArray[i];
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }
}
