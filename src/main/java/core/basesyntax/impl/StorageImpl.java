package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        boolean fl = true;
        for (int i = 0; i < count; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                fl = false;
            }
        }
        if (fl) {
            keys[count] = key;
            values[count] = value;
            count++;
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
