package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_LENGTH = 10;
    private final K[] keys = (K[]) new Object[DEFAULT_LENGTH];
    private final V[] values = (V[]) new Object[DEFAULT_LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            if (keys[i] == null && (values[i] == null || key == null)) {
                keys[i] = key;
                values[i] = value;
                break;
            } else if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            if ((key == keys[i]) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            if (keys[i] == null && values[i] == null) {
                return (i);
            }
        }
        return 0;
    }
}
