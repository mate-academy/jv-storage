package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int counter = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null || key.equals(keys[i]))
                    && (keys[i] == null || keys[i].equals(key)) && values[i] != null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
        keys[counter] = key;
        values[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null || key.equals(keys[i]))
                    && (keys[i] == null || keys[i].equals(key)) && values[i] != null) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
