package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[size];
        values = (V[]) new Object[size];
    }

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
        int searchedIndex = checkKey(key);
        return (searchedIndex == -1) ? null : values[searchedIndex];
    }

    private void addKeyValue(K key, V value) {
        this.size++;
        addKey(key);
        addValue(value);
    }

    private void addKey(K key) {
        K[] newKeys = (K[]) new Object[this.size];
        for (int i = 0; i < this.keys.length; i++) {
            newKeys[i] = this.keys[i];
        }
        newKeys[newKeys.length - 1] = key;
        this.keys = newKeys;
    }

    private void addValue(V value) {
        V[] newValues = (V[]) new Object[this.size];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
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
