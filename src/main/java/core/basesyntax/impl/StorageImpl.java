package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < 10; i++) {
            if (keys[i] == null && (values[i] == null || key == null)) {
                keys[i] = key;
                values[i] = value;
                break;
            } else if (keys[i] != null && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < 10; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < 10; i++) {
            if (keys[i] == null && values[i] == null) {
                return (i);
            }
        }
        return 0;
    }
}
