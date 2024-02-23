package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_SIZE];
        valueArray = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if ((isKeysEquals(key, keyArray[i]))
                    || (keyArray[i] == null && valueArray[i] == null)) {
                keyArray[i] = key;
                valueArray[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (isKeysEquals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = MAX_SIZE - 1; i > 0; i--) {
            if (keyArray[i] != null && valueArray[i] != null) {
                return i + 1;
            }
        }
        return 0;
    }

    private boolean isKeysEquals(K key, K otherKey) {
        return ((otherKey == null && key == null)
                || (otherKey != null && otherKey.equals(key)));
    }
}
