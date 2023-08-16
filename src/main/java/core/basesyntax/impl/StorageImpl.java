package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS];
        values = (V[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        boolean isNewKey = true;
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                //size++;
                isNewKey = false;
                break;

            } else if (keys[i] == null && keys[i] == (key)) {
                values[i] = value;
                isNewKey = false;
                //size++;
                break;
            }
        }
        if (isNewKey) {
            keys[size] = key;
            values[size] = value;
            size++;
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == (key)) {
                return values[i];
            }
            if (keys[i] != null && !(keys[i].getClass().isPrimitive())) {
                if (keys[i].equals(key)) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {

        return size;
    }
}
