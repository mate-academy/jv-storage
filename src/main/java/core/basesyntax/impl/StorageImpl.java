package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object[] keys;
    private Object[] array;
    private int score;

    public StorageImpl() {
        this.keys = new Object[10];
        this.array = new Object[10];
        score = 0;
    }

    @Override
    public void put(K key, V value) {
        int q = 0;

        for (int a = 0; a < keys.length; a++) {
            if ((key == null && keys[a] == null)
                    || (key != null && key.equals((K) (keys[a])))) {
                array[a] = value;
                q++;
            }
        }
        if (q == 0) {
            keys[score] = key;
            array[score] = value;
            score++;
        }

    }

    @Override
    public V get(K key) {
        for (int a = 0; a < keys.length; a++) {
            if (key != null && key.equals((K) (keys[a]))
                    || (key == null && keys[a] == null)) {
                return (V) array[a];
            }
        }
        return null;
    }
}


