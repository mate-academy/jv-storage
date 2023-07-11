package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;

    private final K[] storageKey;
    private final V[] storageValue;
    private int size;

    public StorageImpl() {
        storageKey = (K[]) new Object[MAX_ITEMS_NUMBER];
        storageValue = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storageKey[i] == key || (storageKey[i] != null && storageKey[i].equals(key))) {
                storageValue[i] = value;
                return;
            }
        }
        if (size < MAX_ITEMS_NUMBER) {
            storageKey[size] = key;
            storageValue[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storageKey[i] == key || (storageKey[i] != null && storageKey[i].equals(key))) {
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
