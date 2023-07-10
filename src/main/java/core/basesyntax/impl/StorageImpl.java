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
        if (indexOfKey(key) > -1) {
            keys[indexOfKey(key)] = key;
            values[indexOfKey(key)] = value;
        } else if (indexOfKey(key) == -1 && itemsInStorage < MAX_SIZE) {
            keys[itemsInStorage] = key;
            values[itemsInStorage] = value;
            itemsInStorage++;
        } else {
            throw new RuntimeException(PUT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public V get(K key) {
        if (!containKey(key)) {
            return null;
        }
        return values[indexOfKey(key)];
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

    private boolean containKey(K key) {
        boolean contain = false;
        for (int i = 0; i < itemsInStorage; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                contain = true;
                break;
            }
        }
        return contain;
    }
}
