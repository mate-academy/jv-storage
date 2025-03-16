package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] arrayKey;
    private V[] arrayValue;
    private int count;

    public StorageImpl() {
        this.arrayKey = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.arrayValue = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int indexKey = getIndex(key);
        if (indexKey >= 0) {
            arrayValue[indexKey] = value;
            return;
        }
        arrayKey[count] = key;
        arrayValue[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        int indexKey = getIndex(key);
        if (indexKey >= 0) {
            return arrayValue[indexKey];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private int getIndex(K key) {
        for (int i = 0; i < count; i++) {
            if (key == arrayKey[i] || key != null && key.equals(arrayKey[i])) {
                return i;
            }
        }
        return -1;
    }
}
