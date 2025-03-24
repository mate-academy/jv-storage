package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MaxSize = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MaxSize];
        values = (V[]) new Object[MaxSize];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (keys[i] == key)) {
                values[i] = value;
                return;
            }
        }
        int g = 0;
        for (K somekeys : keys) {
            if (somekeys == null && values[g] == null) {
                keys[g] = key;
                values[g] = value;
                size++;
                return;
            }
            g++;
        }
    }

    @Override
    public V get(K key) {
        int g = 0;
        for (int i = 0; i < MaxSize; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (keys[i] == key)) {

                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
