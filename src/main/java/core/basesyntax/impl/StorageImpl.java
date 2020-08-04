package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;

    private final Integer[] keys;
    private final V[] values;
    private int index;

    public StorageImpl() {
        keys = new Integer[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyHashCode = key == null ? 0 : key.hashCode();
        for (int i = 0; i < index; i++) {
            if (keyHashCode == keys[i].hashCode()) {
                values[i] = value;
            }
        }
        keys[index] = keyHashCode;
        values[index] = value;
        index += 1;
    }

    @Override
    public V get(K key) {
        int keyHashCode = key == null ? 0 : key.hashCode();
        for (int i = 0; i < index; i++) {
            if (keyHashCode == keys[i].hashCode()) {
                return values[i];
            }
        }
        return null;
    }
}


