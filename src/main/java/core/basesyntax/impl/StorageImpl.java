package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_ELEMENTS];
        valueStorage = (V[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyStorage[i])) {
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keyStorage[i], key)) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
