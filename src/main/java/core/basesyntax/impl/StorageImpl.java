package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int STORAGE_SIZE = 10;
    private int currentFilling = 0;
    private K[] keys = (K[]) new Object[STORAGE_SIZE];
    private V[] values = (V[]) new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentFilling; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (currentFilling != STORAGE_SIZE) {
            values[currentFilling] = value;
            keys[currentFilling] = key;
            currentFilling++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentFilling;
    }
}
