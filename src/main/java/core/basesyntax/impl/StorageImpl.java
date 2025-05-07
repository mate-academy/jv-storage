package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private final K[] arrayKey;
    private final V[] arrayValue;

    public StorageImpl() {
        arrayKey = (K[]) new Object[MAX_ITEMS_NUMBER];
        arrayValue = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (arrayKey[i] == null && arrayValue[i] == null) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                size++;
                return;
            }
            if (arrayKey[i] == key && arrayValue[i] != null
                    || arrayKey[i] != null && arrayKey[i].equals(key)) {
                arrayValue[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (arrayKey[i] == key && arrayValue[i] != null
                    || arrayKey[i] != null && arrayKey[i].equals(key)) {
                return arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
