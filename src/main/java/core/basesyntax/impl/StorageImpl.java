package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final Object[] keyArray = new Object[MAX_STORAGE_CAPACITY];
    private final Object[] valueArray = new Object[MAX_STORAGE_CAPACITY];
    private int size;

    private boolean ifResult(K firstKey, K secondKey) {
        return (firstKey == null && secondKey == null)
                || (firstKey != null && firstKey.equals(secondKey));
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (ifResult((K) keyArray[i], key)) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (ifResult((K) keyArray[i], key)) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
