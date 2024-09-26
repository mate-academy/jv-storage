package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_CAPACITY = 10;
    private static final byte NON_EXISTING_INDEX = -1;
    private final Object[] keys;
    private final Object[] values;
    private int size;
    private boolean isAlreadyHaveNullKey;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_CAPACITY];
        values = new Object[MAX_ITEMS_CAPACITY];
        size = 0;
        isAlreadyHaveNullKey = false;
    }

    @Override
    public void put(K key, V value) {
        if (replaceExistingKeyValue(key, value)) {
            return;
        }
        putNewKeyValue(key, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        byte keyIndex = (key == null) ? getNullKeyIndex() : getEqualKeyIndex(key);
        return keyIndex > NON_EXISTING_INDEX ? (V) values[keyIndex] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean replaceExistingKeyValue(K key, V value) {
        if (key == null && !isAlreadyHaveNullKey) {
            return false;
        }
        byte keyIndex = (key == null) ? getNullKeyIndex() : getEqualKeyIndex(key);
        if (keyIndex > NON_EXISTING_INDEX) {
            values[keyIndex] = value;
            return true;
        }
        return false;
    }

    private void putNewKeyValue(K key, V value) {
        if (key == null) {
            isAlreadyHaveNullKey = true;
        }
        for (byte i = 0; i < MAX_ITEMS_CAPACITY; i++) {
            if (keys[i] == null && values[i] == null) {
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

    private byte getNullKeyIndex() {
        for (byte i = 0; i < MAX_ITEMS_CAPACITY; i++) {
            if (keys[i] == null) {
                return i;
            }
        }
        return NON_EXISTING_INDEX;
    }
}
