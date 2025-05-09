package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private K[] kees = (K[]) new Object[CAPACITY];
    private V[] value = (V[]) new Object[CAPACITY];

    public K[] getKees() {
        return kees;
    }

    public V[] getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        boolean isContaincKey = false;

        for (int i = 0; i < getKees().length; i++) {
            if (key != null && getKees()[i].equals(key)) {
                getValue()[i] = value;
                isContaincKey = true;
            }
        }
        if (!isContaincKey) {
            for (int i = 0; i < getKees().length; i++) {
                if (getKees()[i] == null) {
                    getValue()[i] = value;
                    getKees()[i] = key;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < getKees().length; i++) {
            if (key != null && getKees()[i] == key) {
                return getValue()[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        //return -1;
        return getKees().length - 1;
    }
}
