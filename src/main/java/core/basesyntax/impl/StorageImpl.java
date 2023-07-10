package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private static final String PUT_EXCEPTION_MESSAGE =
            "Can't add new data, the storage is full";
    private K[] keys;
    private V[] values;
    private int itemsInStorage = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V []) new Object[MAX_SIZE];

    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index > -1) {
            keys[index] = key;
            values[index] = value;
        } else if (index == -1 && itemsInStorage < MAX_SIZE) {
            keys[itemsInStorage] = key;
            values[itemsInStorage] = value;
            itemsInStorage++;
        } else {
            throw new RuntimeException(PUT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return itemsInStorage;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < itemsInStorage; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

}
