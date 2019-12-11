package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object[] arrayOfKeys;
    private Object[] arrayOfValues;
    private int size = 10;

    public StorageImpl() {
        arrayOfKeys = new Object[size];
        arrayOfValues = new Object[size];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (key == null || arrayOfKeys[i] == null && arrayOfValues[i] == null) {
                arrayOfKeys[i] = key;
                arrayOfValues[i] = value;
                break;
            } else if (key.equals(arrayOfKeys[i])) {
                arrayOfValues[i] = value;
                break;
            }

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if ((key != null && key.equals(arrayOfKeys[i]))
                    || (key == null && key == arrayOfKeys[i])) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }
}
