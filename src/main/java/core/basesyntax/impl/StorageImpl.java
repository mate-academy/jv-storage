package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private V[] values;
    private K[] keys;
    private int keyValue;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    public boolean equelsKeys(K key1,K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyValue;i++) {
            if (equelsKeys(keys[i],key)) {
                values[i] = value;
                return;
            }
        }
        keys[keyValue] = key;
        values[keyValue] = value;
        keyValue++;
    }

    @Override
    public V get(K key) {
        for (int i = 0;i < keyValue;i++) {
            if (equelsKeys(keys[i],key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyValue;
    }
}
