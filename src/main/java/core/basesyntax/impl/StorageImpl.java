package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        this.size = 0;
        keys = new Object[10];
        values = new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
            size++;
            return;
        } else {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null) {
                    if (key == null) {
                        if (values[i] == null) {
                            size++;
                        }
                        values[i] = value;
                        break;
                    } else if (values[i] == null) {
                        values[i] = value;
                        keys[i] = key;
                        size++;
                        break;
                    }
                } else if (keys[i].equals(key)) {
                    values[i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] != null) {
                if (keys[i] == key) {
                    return (V) values[i];
                }
            } else if (keys[i] == null && values[i] == null) {
                return null;
            } else if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
