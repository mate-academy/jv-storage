package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_LENGTH];
        values = (V[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
<<<<<<< HEAD
            if (isKeysEqual(keys[i], key)) {
=======
            if (equalKeys(keys[i], key)) {
>>>>>>> c634e0e411fae5ce4184cc1132da7a6e0b0b0ac0
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
<<<<<<< HEAD
            if (isKeysEqual(keys[i], key)) {
=======
            if (equalKeys(keys[i], key)) {
>>>>>>> c634e0e411fae5ce4184cc1132da7a6e0b0b0ac0
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

<<<<<<< HEAD
    private boolean isKeysEqual(K firstKey, K secondKey) {
=======
    private boolean equalKeys(K firstKey, K secondKey) {
>>>>>>> c634e0e411fae5ce4184cc1132da7a6e0b0b0ac0
        return (firstKey == null ? secondKey == null : firstKey.equals(secondKey));
    }
}
