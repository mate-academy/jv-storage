package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    private final V[] values = (V[]) new Object[MAX_ITEMS_NUMBER];
    private int storageSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && keys[i] == null && values[i] != null) {
                continue;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }
            if (key == null && keys[i] == null && value != null && values[i] == null) {
                values[i] = value;
                storageSize++;
                break;
            }
            if (key == null && keys[i] == null && value != null && values[i] != null) {
                values[i] = value;
                break;
            }
            if (keys[i] == null && key != null) {
                keys[i] = key;
                values[i] = value;
                storageSize++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int index = 0; index < storageSize; index++) {
            if (key == null && keys[index] == null) {
                return values[index];
            }
            if (keys[index] != null && keys[index].equals(key)) {
                return values[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
