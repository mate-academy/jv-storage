package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_SIZE = 10;
    private K[] keysStorage;
    private V[] valuesStorage;
    private int size;

    public StorageImpl() {
        keysStorage = (K[]) new Object[MAX_ELEMENTS_SIZE];
        valuesStorage = (V[]) new Object[MAX_ELEMENTS_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equalKeysCondition(keysStorage[i], key)) {
                valuesStorage[i] = value;
                return;
            }
        }
        keysStorage[size] = key;
        valuesStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (equalKeysCondition(keysStorage[i], key)) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean equalKeysCondition(K firstKey, K secondKey) {
        return firstKey == secondKey || firstKey != null && firstKey.equals(secondKey);
    }
}
