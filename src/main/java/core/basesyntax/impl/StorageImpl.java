package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.security.Key;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_CAPACITY = 10;
    private static final byte NON_EXISTING_INDEX = -1;
    private K keys[];
    private V values[];
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_CAPACITY];
        values = (V[]) new Object[MAX_ITEMS_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (replaceExistingKeyValue(key, value)) {
            return;
        }
        putNewKeyValue(key, value);
    }


    @Override
    public V get(K key) {
        byte keyIndex = getEqualKeyIndex(key);
        return keyIndex > NON_EXISTING_INDEX
                ? values[keyIndex]
                : null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean replaceExistingKeyValue(K key, V value) {
        byte keyIndex = getEqualKeyIndex(key);
        if (keyIndex > NON_EXISTING_INDEX) {
            values[keyIndex] = value;
            return true;
        }
        return false;
    }

    private void putNewKeyValue(K key, V value) {
        for (byte i = 0; i < MAX_ITEMS_CAPACITY; i++) {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
        }
    }

    private byte getEqualKeyIndex(K key) {
        for (byte i = 0; i < MAX_ITEMS_CAPACITY; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NON_EXISTING_INDEX;
    }
}
