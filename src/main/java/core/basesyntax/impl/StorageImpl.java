package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        keys[indexOfSuitableSlot(key)] = key;
        values[indexOfSuitableSlot(key)] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (equalsCheck(keys[i], values[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private int indexOfSuitableSlot(K key) {
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (equalsCheck(keys[i], values[i], key) || values[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private boolean equalsCheck(K key, V value, K keyToCompare) {
        return (keyToCompare == key) || (key != null && key.equals(keyToCompare));
    }
}
