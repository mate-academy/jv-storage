package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int storageSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
        storageSize = 0;
    }

    private K getKeyByIndex(int index) {
        return keys[index];
    }

    private void setKeyByIndex(int index, K key) {
        keys[index] = key;
    }

    private V getValueByIndex(int index) {
        return values[index];
    }

    private void setValueByIndex(int index, V value) {
        values[index] = value;
    }

    @Override
    public void put(K key, V value) {
        int i;
        for (i = 0; i < storageSize; i++) {
            if (key == null && getKeyByIndex(i) == null
                    || key != null && key.equals(getKeyByIndex(i))) {
                setValueByIndex(i, value);
                return;
            }
        }
        setKeyByIndex(i, key);
        setValueByIndex(i, value);
        storageSize += 1;
    }

    @Override
    public V get(K key) {
        int i;
        for (i = 0; i < storageSize; i++) {
            if (key == null && getKeyByIndex(i) == null
                    || key != null && key.equals(getKeyByIndex(i))) {
                break;
            }
        }
        return getValueByIndex(i);
    }

    @Override
    public int size() {
        return storageSize;
    }
}
