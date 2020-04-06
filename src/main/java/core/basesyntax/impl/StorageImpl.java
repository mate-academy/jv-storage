package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private Object[] keys;
    private Object[] values;
    private int index;

    public StorageImpl() {
        this.keys = new Object[LENGTH];
        this.values = new Object[LENGTH];
        this.index = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean isExist = false;
        if (key == null) {
            for (int i = 0; i < index; i++) {
                if (key == keys[i]) {
                    keys[i] = key;
                    values[i] = value;
                    isExist = true;
                }
            }
        } else {
            for (int i = 0; i < index; i++) {
                if (key.equals(keys[i])) {
                    keys[i] = key;
                    values[i] = value;
                    isExist = true;
                }
            }
        }
        if (!isExist) {
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < LENGTH; i++) {
            if (key == null) {
                if (key == keys[i]) {
                    return (V) values[i];
                }
            } else {
                if (key.equals(keys[i])) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }
}
