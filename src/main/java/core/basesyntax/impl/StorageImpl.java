package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int OBJECT_ARRAY_INDEX = 10;
    private int putCounter = 0;
    private Object[] keyData;
    private Object[] valueData;

    public StorageImpl() {
        valueData = new Object[OBJECT_ARRAY_INDEX];
        keyData = new Object[OBJECT_ARRAY_INDEX];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < putCounter; i++) {
            if ((keyData[i] == null && key == keyData[i])
                    || (key != null
                    && (key == keyData[i] || key.equals(keyData[i])))) {
                valueData[i] = value;
                return;
            }
        }
        keyData[putCounter] = key;
        valueData[putCounter] = value;
        putCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < OBJECT_ARRAY_INDEX; i++) {
            if ((keyData[i] == null && key == keyData[i])
                    || (key != null
                    && (key == keyData[i] || key.equals(keyData[i])))) {
                return (V) valueData[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return putCounter;
    }
}
