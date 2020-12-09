package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int STORAGE_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_CAPACITY];
        this.values = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if ((key == null && keys[i] == null)
                    || (keys[i] != null && keys[i].equals(key))
                    || (keys[i] == null && values[i] == null)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if ((key != null && key.equals(keys[i])) || (key == null && keys[i] == null)) {
                return values[i];
            }
        }
        return null;
    }
}
