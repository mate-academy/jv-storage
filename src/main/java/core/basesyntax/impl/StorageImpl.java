package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBERS_OF_ELEMENTS = 10;
    private K[] keys = (K[]) new Object[MAXIMUM_NUMBERS_OF_ELEMENTS];
    private V[] values = (V[]) new Object[MAXIMUM_NUMBERS_OF_ELEMENTS];
    private int currentLength = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentLength; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[currentLength] = key;
        values[currentLength] = value;
        currentLength++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentLength; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }
}
