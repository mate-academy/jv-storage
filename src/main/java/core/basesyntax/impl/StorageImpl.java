package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_LENGTH_OF_STORAGE = 10;
    private final Object[] keysStorage;
    private final Object[] valuesStorage;
    private int size;

    public StorageImpl() {
        keysStorage = new Object[MAX_LENGTH_OF_STORAGE];
        valuesStorage = new Object[MAX_LENGTH_OF_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(keysStorage[i], key)) {
                valuesStorage[i] = value;
                return;
            }
        }
        keysStorage[size] = key;
        valuesStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(keysStorage[i], key)) {
                return (V) valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean compareKeys(Object firstKey, Object secondKey) {
        return (firstKey == secondKey) || (firstKey != null && firstKey.equals(secondKey));
    }
}
