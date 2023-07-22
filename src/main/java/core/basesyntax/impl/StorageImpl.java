package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int arrayLength = 0;
    private Object[] keyItems = new Object[MAX_SIZE];
    private Object[] valueItems = new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayLength; i++) {
            if ((keyItems[i] != null && (keyItems[i].equals(key)) || keyItems[i] == key)) {
                valueItems[i] = value;
                arrayLength--;
            }
        }
        keyItems[arrayLength] = key;
        valueItems[arrayLength] = value;
        arrayLength++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayLength; i++) {
            if (keyItems[i] != null && (keyItems[i].equals(key) || keyItems[i] == key)) {
                return (V) valueItems[i];
            } else if (keyItems[i] == key) {
                return (V) valueItems[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arrayLength;
    }
}
