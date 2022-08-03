package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_AMOUNT_STORAGE = 10;
    private final V[] valueArrays;
    private final K[] keyArrays;
    private int size;
    private int indexValue;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        valueArrays = (V[]) new Object[MAX_AMOUNT_STORAGE];
        keyArrays = (K[]) new Object[MAX_AMOUNT_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        if (!isKey(keyArrays, key)) {
            valueArrays[size] = value;
            keyArrays[size] = key;
            size++;
        } else {
            valueArrays[indexValue] = value;
        }
    }

    private boolean isKey(K[] keyArrays, K key) {
        for (int i = 0; i < keyArrays.length; i++) {
            if (keyArrays[i] == null && valueArrays[i] == null) {
                return false;
            } else if (key == null && keyArrays[i] == null && valueArrays[i] != null
                    || keyArrays[i] != null && keyArrays[i].equals(key)) {
                indexValue = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (isKey(keyArrays, key)) {
            return valueArrays[indexValue];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
