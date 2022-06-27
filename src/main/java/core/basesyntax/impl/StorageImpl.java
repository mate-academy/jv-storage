package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private final K[] keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private final V[] values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private int size;

    @Override
    public void put(K key, V value) {

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
