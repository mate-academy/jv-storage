package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int MAX_ARRAY_SIZE = 10;
    public K[] keyArray = (K[]) new Object[MAX_ARRAY_SIZE];
    public V[] valueArray = (V[]) new Object[MAX_ARRAY_SIZE];

    public void put(K key, V value) {
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (keyArray[i] == key || key != null
                    && keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = (V) value;
                keyArray[i] = (K) key;
                return;
            } else if (keyArray[i] == valueArray[i] && key != null) {
                valueArray[i] = (V) value;
                keyArray[i] = (K) key;
                return;
            }
        }
    }

    public V get(K key) {
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (key == keyArray[i] || key != null
                    && keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}

