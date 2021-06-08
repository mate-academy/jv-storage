package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size = 0;
    private Object [] keys = new Object [CAPACITY];
    private Object [] values = new Object [CAPACITY];

    @Override
    public void put(K key, V value) {
        int counterSameKeys = 0;
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                counterSameKeys++;
                values[i] = value;
            }
        }
        if (counterSameKeys == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null) && (key == null)) {
                return (V) values[i];
            }
            if ((keys[i] != null) && (keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
