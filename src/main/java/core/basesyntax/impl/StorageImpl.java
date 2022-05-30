package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_LENGTH];
        values = (V[]) new Object[ARRAY_LENGTH];
    }

    private int getIndex(K key) {
        int i = 0;
        for (; i < values.length; i++) {
            boolean a = values[i] == null;
            boolean b = keys[i] == key || key != null && key.equals(keys[i]);
            if ((a || b) // condition for put
                    || (!a && b)) { // condition for get
                break;
            }
        }
        return i;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index >= ARRAY_LENGTH || values[index] == null) {
            keys[index] = key;
            values[index] = value;
            size++;
            return;
        }
        if (key == keys[index] || key != null && key.equals(keys[index])) {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index < values.length) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
