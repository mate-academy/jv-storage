package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys = new Object[MAX_CAPACITY];
    private Object[] values = new Object[MAX_CAPACITY];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        boolean flag = true;

        for (int i = 0; i < index; i++) {
            if (keysEqual((K) keys[i], key)) {
                values[i] = value;
                flag = false;
            }
        }
        if (flag) {
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (keysEqual((K) keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }

    private boolean keysEqual(K a, K b) {
        return (a == null && b == null)
                || (a != null && a.equals(b));
    }
}
