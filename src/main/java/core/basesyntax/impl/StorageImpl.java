package core.basesyntax.impl;

import core.basesyntax.Storage;


public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keyArray = new Object[MAX_CAPACITY];
    private Object[] valueArray = new Object[MAX_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int count = counter(key);
        if (count == -1) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else if (count >= 0 && count <= size - 1) {
            valueArray[count] = value;
        }
    }

    @Override
    public V get(K key) {
        int count = counter(key);
        if (count == -1) {
            return (V) null;
        }
        return (V) valueArray[count];
    }

    @Override
    public int size () {
        return size;
    }
    public int counter (K key) {
        int count = -1;
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (key == keyArray[i]) {
                    count = i;
                }
            }
        } else {
                for (int i = 0; i < size; i++) {
                    if (key.equals(keyArray[i])) {
                        count = i;
                    }
                }
            }
            return count;
        }
}
