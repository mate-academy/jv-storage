package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;

    private K[] storageKey;
    private V[] storageValue;

    private int count = 0;

    public StorageImpl() {
        storageKey = (K[]) new Object[MAX_ITEMS_NUMBER];
        storageValue = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (storageKey[i] == null && key == null) {
                storageValue[i] = value;
                return;
            }
            if (storageKey[i] != null && storageKey[i].equals(key)) {
                storageValue[i] = value;
                return;
            }
        }
        if (count != MAX_ITEMS_NUMBER) {
            storageKey[count] = key;
            storageValue[count] = value;
            count++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= count; i++) {
            if (storageKey[i] == null && key == null
                    || storageKey[i] != null && storageKey[i].equals(key)) {
                return storageValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

}
