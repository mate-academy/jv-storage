package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final byte MAX_ITEMS_COUNT = 10;
    private byte size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_COUNT];
        values = (V[]) new Object[MAX_ITEMS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        byte keyIndex = getKeyIndex(key);

        if (keyIndex != -1) {
            keys[keyIndex] = key;
            values[keyIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        byte keyIndex = getKeyIndex(key);

        if (keyIndex != -1) {
            return values[keyIndex];
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private byte getKeyIndex(K key) {
        for (byte i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }

        return -1;
    }
}
