package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private V[] arrayValue = (V[]) new Object[0];
    private K[] arrayKey = (K[]) new Object[0];
    private V nullValue = null;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            nullValue = value;
            return;
        }
        if (key.getClass().getName().equals("java.lang.Integer")) {
            putInt(key, value);
        } else {
            putObject(key, value);
        }
    }

    private void putInt(K key, V value) {
        if ((int) key <= size()) {
            arrayValue[(int) key - 1] = value;
        }
        if ((int) key > size()) {
            V[] arrayNew = (V[]) new Object[(int) key];
            arrayNew[(int) key - 1] = value;
            for (int i = 0; i < size(); i++) {
                arrayNew[i] = arrayValue[i];
            }
            arrayValue = arrayNew;
        }
    }

    private void putObject(K key, V value) {
        Object[] arrayValueTemp = null;
        Object[] arrayKeyTemp = null;
        int putIndex = -1;
        for (int i = 0; i < size(); i++) {
            if (key.equals(arrayKey[i])) {
                putIndex = i;
            }
        }
        if (putIndex == -1) {
            arrayValueTemp = new Object[size() + 1];
            arrayKeyTemp = new Object[size() + 1];
            arrayValueTemp[arrayValueTemp.length - 1] = value;
            arrayKeyTemp[arrayKeyTemp.length - 1] = key;
            for (int i = 0; i < size(); i++) {
                arrayValueTemp[i] = arrayValue[i];
                arrayKeyTemp[i] = arrayKey[i];
            }
            arrayValue = (V[]) arrayValueTemp;
            arrayKey = (K[]) arrayKeyTemp;
        } else if (putIndex <= size() - 1) {
            arrayKey[putIndex] = key;
            arrayValue[putIndex] = value;
        }
    }

    public void putInteger(K key, V value) {
        if (key == null) {
            return;
        }
        if ((int) key <= size()) {
            arrayValue[(int) key - 1] = value;
        }
        if ((int) key > size()) {
            V[] arrayNew = (V[]) new Object[(int) key];
            arrayNew[(int) key - 1] = value;
            for (int i = 0; i < size(); i++) {
                arrayNew[i] = arrayValue[i];
            }
            arrayValue = arrayNew;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return nullValue;
        }
        if (key.getClass().getName().equals("java.lang.Integer")) {
            return getInt(key);
        }
        return getObject(key);
    }

    public V getObject(K key) {
        for (int i = 0; i < size(); i++) {
            if (arrayKey[i].equals(key)) {
                return arrayValue[i];
            }
        }
        return null;
    }

    public V getInt(K key) {
        if ((int) key > size()) {
            return null;
        }
        return arrayValue[(int) key - 1];
    }

    @Override
    public int size() {
        if (arrayValue == null) {
            return -1;
        }
        return arrayValue.length;
    }
}
