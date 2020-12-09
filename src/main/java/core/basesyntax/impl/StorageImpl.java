package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        this.values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0;i < MAX_ARRAY_LENGTH;i++) {
            if ((key == null && keys[i] == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                break;
            } else if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(Object key) {
        for (int i = 0;i < MAX_ARRAY_LENGTH;i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }
}
