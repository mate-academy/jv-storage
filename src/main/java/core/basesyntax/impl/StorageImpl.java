package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        if (contains(key)) {
            for (int i = 0; i < keys.length; i++) {
                if (compareKeys(keys[i], key)) {
                    values[i] = value;
                }
            }
        } else {
            if (index < CAPACITY) {
                keys[index] = key;
                values[index] = value;
                index++;
            } else {
                System.out.println("The storage is full!");
            }
        }
    }

    @Override
    public V get(K key) {
        return contains(key) ? values[indexOf(key)] : null;
    }

    public boolean contains(K key) {
        return indexOf(key) > -1;
    }

    private int indexOf(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (compareKeys(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean compareKeys(K key1, K key2) {
        return (key1 == key2) || (key1 != null && key1.equals(key2));
    }
}
