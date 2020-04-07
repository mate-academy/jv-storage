package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int LENGTH = 10;

    K[] arrayKey;
    V[] arrayValue;
    int next;

    public StorageImpl() {
        arrayKey = (K[]) new Object[LENGTH];
        arrayValue = (V[]) new Object[LENGTH];
        next = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < next; i++) {
            if ((arrayKey[i] == key) || (arrayKey[i] != null && arrayKey[i].equals(key))) {
                arrayValue[i] = value;
            }
        }
        arrayKey[next] = key;
        arrayValue[next++] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < next; i++) {
            if ((arrayKey[i] == key) || (arrayKey[i] != null && arrayKey[i].equals(key))) {
                return arrayValue[i];
            }
        }
        return null;
    }
}
