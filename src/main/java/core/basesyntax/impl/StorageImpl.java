package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object[] keys;
    private Object[] array;
    private int score;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        array = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        for (int a = 0; a < score; a++) {
            if (key != null ? key.equals(keys[a])
                    : keys[a] == null) {
                array[a] = value;
                return;
            }
        }
        keys[score] = key;
        array[score] = value;
        score++;
    }

    @Override
    public V get(K key) {
        for (int a = 0; a < score; a++) {
            if (key != null ? key.equals(keys[a])
                    : keys[a] == null) {
                return (V) array[a];
            }
        }
        return null;
    }
}
