package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int size;

    private final K[] storageKey;
    private final V[] storageValue;

    public StorageImpl() {
        this.storageKey = (K[]) new Object[MAX_CAPACITY];
        this.storageValue = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if ((storageKey[i] != null && storageKey[i].equals(key))
                    || (storageKey[i] == null && key == null)) {
                storageValue[i] = value;
                return;
            }
        }

        storageKey[size] = key;
        storageValue[size] = value;

        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if ((storageKey[i] != null && storageKey[i].equals(key))
                    || (storageKey[i] == null && key == null)) {
                return storageValue[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
