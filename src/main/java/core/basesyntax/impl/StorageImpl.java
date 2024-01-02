package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keys = (K[]) new Object[this.size];
    private V[] values = (V[]) new Object[this.size];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int replaceIndex = checkKey(key);
        if (replaceIndex != -1) {
            values[replaceIndex] = value;
        } else {
            addKeyValue(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && key != null && keys[i].equals(key)) {
                return values[i];
            }
            if (keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }

    private void addKeyValue(K key, V value) {
        this.size++;
        K[] newKeys = (K[]) new Object[this.size];
        System.arraycopy(this.keys, 0, newKeys, 0, this.keys.length);
        newKeys[newKeys.length - 1] = key;
        this.keys = newKeys;

        V[] newValues = (V[]) new Object[this.size];
        System.arraycopy(this.values, 0, newValues, 0, this.values.length);
        newValues[newValues.length - 1] = value;
        this.values = newValues;
    }

    private int checkKey(K wantedKey) {
        for (int i = 0; i < this.keys.length; i++) {
            if (keys[i] == wantedKey || keys[i] != null && keys[i].equals(wantedKey)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
