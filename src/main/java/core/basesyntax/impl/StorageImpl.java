package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K,V> {
    private int count = 0;
    private Object[] keyArray = new Object[16];
    private Object[] valueArray = new Object[16];

    @Override
    public void put(K key, V value) {
        if (count == 0) {
            keyArray[count] = key;
            valueArray[count] = value;
        }
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                valueArray[i] = value;
            }
            keyArray[count] = key;
            valueArray[count] = value;
        }
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null || key.equals(keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }
}

