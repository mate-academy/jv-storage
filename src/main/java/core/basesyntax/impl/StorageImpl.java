package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_NUMBER];
        values = (V[]) new Object[MAXIMUM_NUMBER];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (isKeyEquals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (isKeyEquals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    public K[] getKeys() {
        return keys;
    }

    public V[] getValues() {
        return values;
    }

    private boolean isKeyEquals(K key, K key2) {
        return (key == key2)
                || (key != null && key.equals(key2));
    }
}
