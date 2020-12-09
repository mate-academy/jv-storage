package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_NUMBER = 10;
    private K[] arrayOfKeys;
    private V[] arrayOfValues;

    public StorageImpl() {
        this.arrayOfKeys = (K[]) new Object[MAX_ELEMENT_NUMBER];
        this.arrayOfValues = (V[]) new Object[MAX_ELEMENT_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENT_NUMBER; i++) {
            if ((arrayOfKeys[i] == key) || (arrayOfKeys[i] != null && arrayOfKeys[i].equals(key))) {
                arrayOfValues[i] = value;
                break;
            } else if (arrayOfValues[i] == null && arrayOfKeys[i] == null) {
                arrayOfKeys[i] = key;
                arrayOfValues[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ELEMENT_NUMBER; i++) {
            if (key != null && key.equals(arrayOfKeys[i]) || (arrayOfKeys[i] == key)) {
                return arrayOfValues[i];
            }
        }
        return null;
    }
}
