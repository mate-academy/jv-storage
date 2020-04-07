package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int ARRAY_LENGTH = 10;
    K[] keyArray = (K[]) new Object[0];
    V[] valuesArray = (V[]) new Object[0];

    public StorageImpl() {

    }

    @Override
    public void put(K key, V value) {
        if (keyArray.length > ARRAY_LENGTH) {
            if (checking(key) != null) {
                valuesArray[checking(key)] = value;
            }
        } else {
            if (checking(key) == null) {
                K[] cloneOfKeyArray = keyArray.clone();
                V[] cloneOfValuesArray = valuesArray.clone();
                keyArray = (K[]) new Object[keyArray.length + 1];
                valuesArray = (V[]) new Object[valuesArray.length + 1];

                for (int i = 0; i < cloneOfKeyArray.length; i++) {
                    keyArray[i] = cloneOfKeyArray[i];
                    valuesArray[i] = cloneOfValuesArray[i];
                }
                keyArray[keyArray.length - 1] = key;
                valuesArray[valuesArray.length - 1] = value;
            } else {
                if (checking(key) != null) {
                    valuesArray[checking(key)] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (checking(key) != null) {
            return valuesArray[checking(key)];
        } else {
            return null;
        }
    }

    public Integer checking(K key) {
        if (key == null) {
            for (int i = 0; i < keyArray.length; i++) {
                if (keyArray[i] == null) {
                    return i;
                }
            }
            return null;
        }
        for (int j = 0; j < keyArray.length; j++) {
            if (key.equals(keyArray[j])) {
                return j;
            }
        }
        return null;
    }
}
