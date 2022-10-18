package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int COUNT_OF_ARRAY = 10;
    private K [] keys = (K[]) new Object[COUNT_OF_ARRAY];
    private V [] values = (V[]) new Object[COUNT_OF_ARRAY];
    private int storageSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= storageSize; i++) {
            if (keys[i] == null && key == null && values[i] != null
                    || (keys[i] != null && keys[i].equals(key))) {
                keys[i] = key;
                values[i] = value;
                break;
            }
            keys[storageSize] = key;
            values[storageSize] = value;
            storageSize++;
            break;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (key == null && keys[i] == null)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
