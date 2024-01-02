package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keys;
    private V[] values;
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (this.size == 0) {
            this.size++;
            putFirst(key, value);
        } else {
            if (isKey(key)) {
                replaceValue(key,value);
            } else {
                addKeyValue(key, value);
            }
        }
    }

    private void putFirst(K key, V value) {
        keys = (K[]) new Object[this.size];
        keys[0] = key;
        values = (V[]) new Object[this.size];
        values[0] = value;
    }

    private void replaceValue(K key, V value) {
        for (int i = 0; i < this.size; i++) {
            if (key != null && keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }
            if (key == keys[i]) {
                values[i] = value;
                break;
            }
        }
    }

    private void addKeyValue(K key, V value) {
        this.size++;
        K[] newKeys = (K[]) new Object[this.size];
        System.arraycopy(this.keys, 0, newKeys, 0, this.keys.length);
        newKeys[newKeys.length - 1] = key;
        setKeys(newKeys);

        V[] newValues = (V[]) new Object[this.size];
        System.arraycopy(this.values, 0, newValues, 0, this.values.length);
        newValues[newValues.length - 1] = value;
        setValues(newValues);
    }

    private boolean isKey(K wantedKey) {
        for (K key : this.keys) {
            if (key != null && wantedKey != null && key.equals(wantedKey)) {
                return true;
            }
            if (key == wantedKey) {
                return true;
            }
        }
        return false;
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

    @Override
    public int size() {
        return this.size;
    }

    public void setKeys(K[] keys) {
        this.keys = keys;
    }

    public void setValues(V[] values) {
        this.values = values;
    }
}
