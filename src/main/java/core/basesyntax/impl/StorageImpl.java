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
        for (int i = 0; i < getKees().length; i++ ) {
            if (key == null && kees[i] == null) {
                
            }


        }

    }

    @Override
    public V get(K key) {

        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
