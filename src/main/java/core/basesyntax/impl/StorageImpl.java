package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object[] keys;
    private Object[] array;
    private int score;

    public StorageImpl() {
        keys = new Object[10];
        array = new Object[10];
        score = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int a = 0; a < keys.length; a++) {
            if (key != null ? key.equals(keys[a])
                    : keys[a] == null) {
                array[a] = value;
            }
        }
        keys[score] = key;
        array[score] = value;
        score++;
    }

    @Override
    public V get(K key) {
        for (int a = 0; a < keys.length; a++) {
            if (key != null ? key.equals(keys[a])
                    : keys[a] == null) {
                return (V) array[a];
            }
        }
        return null;
    }
}
