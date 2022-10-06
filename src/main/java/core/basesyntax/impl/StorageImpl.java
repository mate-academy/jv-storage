package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size = 0;
    private final K[] keyStorage;
    private final V[] valueStorage;

    public StorageImpl() {
        this.keyStorage = (K[]) new Object[MAX_SIZE];
        this.valueStorage = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Integer index = foundIndex(key);

        if (index != null) {
            valueStorage[index] = value;
        } else if (size < MAX_SIZE) {
            keyStorage[size] = key;
            valueStorage[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        Integer index = foundIndex(key);

        if (index != null) {
            return valueStorage[index];
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Integer foundIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || (keyStorage[i] != null
                    && keyStorage[i].equals(key))) {
                return i;
            }
        }

        return null;
    }
}
