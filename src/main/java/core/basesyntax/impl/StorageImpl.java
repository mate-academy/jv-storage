package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int counter;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_LENGTH];
        values = (V[]) new Object[ARRAY_LENGTH];
        counter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if ((keys[i] == null && values[i] == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                keys[i] = key;
                values[i] = value;
                counter++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (keys[i] != null && keys[i].equals(key) || (keys[i] == null && key == null)) {
                return values[i];
            }
        }
        return null;
    }
}
