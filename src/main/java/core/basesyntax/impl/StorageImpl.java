package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int COUNT_OF_ARRAY = 10;
    private K [] keys = (K[]) new Object[COUNT_OF_ARRAY];
    private V [] values = (V[]) new Object[COUNT_OF_ARRAY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && values[i] == null)
                    || (keys[i] == null && key == null && values[i] != null)
                    || (keys[i] != null && keys[i].equals(key))) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            } else if (key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int storageSize = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null || values[i] != null) {
                storageSize++;
            }
        }
        return storageSize;
    }
}
