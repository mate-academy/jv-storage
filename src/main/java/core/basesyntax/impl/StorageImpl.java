package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int index = 0;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);

        if (keyIndex != -1) {
            values[keyIndex] = value;
        } else if (index < keys.length) {
            keys[index] = key;
            values[index] = value;
            index++;
        }

    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);

        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if ((keys[i] == null && keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
