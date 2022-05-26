package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private Object[] keyArray;
    private Object[] valueArray;
    private int count;

    public StorageImpl() {
        keyArray = new Object[MAX_STORAGE];
        valueArray = new Object[MAX_STORAGE];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keyArray[count] = key;
            valueArray[count] = value;
            count++;
        } else {
            valueArray[count - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key != null && key.equals(keyArray[i]) || key == keyArray[i]) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
