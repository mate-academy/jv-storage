package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;
    private boolean isKeyEqual;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (get(key) != null) {
            values[index] = value;
            keys[index] = key;
            return;
        } else {
            for (int i = 0; i < values.length; i++) {
                if (keys[i] == null && values[i] == null) {
                    values[i] = value;
                    keys[i] = key;
                    size++;
                    return;
                }
            }
        }
    }


        /*for (int i = 0; i < values.length; i++) {
            if (keys[i] != null && keys[i].equals(key)
                    || (key == null && keys[i] == null)) {
                values[i] = value;
                keys[i] = key;
                return;
            } else if (keys[i] == null && values[i] == null) {
                values[i] = value;
                keys[i] = key;
                size++;
                return;
            }
        }
    }*/

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return (index != -1) ?
                (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    /*public int getNullKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                return i;
            }
        }
        return -1;
    }*/
}
