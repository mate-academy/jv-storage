package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final int arrayCapacity = 10;
    private Object[] arrayOfKeys = new Object[arrayCapacity];
    private Object[] arrayOfValues = new Object[arrayCapacity];

    int size = 1;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayCapacity - size; i++) {
            arrayOfKeys[i] = key;
            arrayOfValues[i] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (key != null && key.equals((arrayOfKeys[i]))
                    || arrayOfKeys[i] == null) {
                return (V) arrayOfValues[i];
            }
        }
        return null;

    }
}
