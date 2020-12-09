package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int MAX_ARRAY_SIZE = 10;
    public K[] keyArray = (K[]) new Object[MAX_ARRAY_SIZE];
    public V[] valueArray = (V[]) new Object[MAX_ARRAY_SIZE];
    private int iterator = 0;

    public void put(K key, V value) {
        for (int i = 0; i <= iterator; i++) {
            if (keyArray[i] == key || key != null
                    && keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = (V) value;
                keyArray[i] = (K) key;
            } else if (keyArray[i] == valueArray[i] && key != null) {
                valueArray[i] = (V) value;
                keyArray[i] = (K) key;
            }
        }
        iterator++;
    }

    public V get(K key) {
        for (int i = 0; i <= iterator; i++) {
            if (key == keyArray[i] || key != null
                    && keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }
}


