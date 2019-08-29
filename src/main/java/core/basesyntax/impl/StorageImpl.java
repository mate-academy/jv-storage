package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private int capacity = 16;
    private int fill = 0;
    private Object[] keys = new Object[capacity];
    private Object[] values = new Object[capacity];

    @Override
    public void put(K key, V value) {
        extension();
        for (int i = 0; i < fill; i++) {
            if (keys[i] == key || keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }

        keys[fill] = key;
        values[fill] = value;
        fill++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < fill; i++) {
            if (keys[i] == key || keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    public void extension() {
        if (fill == keys.length) {
            keys = Arrays.copyOf(keys, keys.length * 2);
            values = Arrays.copyOf(values, values.length * 2);
        }
    }
}

