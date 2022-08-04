package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private K[] keysArray = (K[]) new Object[10];
    private V[] valueArray = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keysArray[i] == null && key == null)
                    || (keysArray[i] != null && keysArray[i].equals(key))) {
                valueArray[i] = value;
                return;
            }
        }

        keysArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if ((keysArray[i] == null && key == null)
                    || (keysArray[i] != null && keysArray[i].equals(key))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
