package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys = (K[]) new Object[MAX_STORAGE_SIZE];
    private final V[] items = (V[]) new Object[MAX_STORAGE_SIZE];
    private int itemsCode;

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[itemsCode] = key;
            items[itemsCode] = value;
            itemsCode++;
        } else {
            items[itemsCode - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < itemsCode; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return items[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return itemsCode;
    }
}
