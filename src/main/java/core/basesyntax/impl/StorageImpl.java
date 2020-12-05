package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int length = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        throw new RuntimeException("Can't fined key");
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            values[indexOfKey(key)] = value;

        } else {
            keys[length] = key;
            values[length++] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }
}
