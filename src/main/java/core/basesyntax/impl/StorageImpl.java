package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int count = -1;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
    }

    public StorageImpl(K key, V value) {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
        put(key,value);
    }

    @Override
    public void put(K key, V value) {
        boolean isFound = false;
        if (count >= 0) {
            for (int i = 0; i <= count; i++) {
                if ((key != null && key.equals(keys[i])) || (key == null && keys[i] == null)) {
                    values[i] = value;
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            count++;
            keys[count] = key;
            values[count] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= count; i++) {
            if ((key != null && key.equals(keys[i])) || (key == null && keys[i] == null)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count > 0 ? count + 1 : 0;
    }
}
