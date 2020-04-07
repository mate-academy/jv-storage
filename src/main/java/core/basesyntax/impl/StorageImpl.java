package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;
    private int arrayCount;
    private Object[] arrayKay;
    private Object[] arrayValue;

    public <K, V> StorageImpl() {
        arrayKay = new Object[ARRAY_SIZE];
        arrayValue = new Object[ARRAY_SIZE];
        arrayCount = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayCount; i++) {
            if ((arrayKay[i] == key) || (arrayKay[i] != null && arrayKay[i].equals(key))) {
                arrayValue[i] = value;
                return;
            }
        }
        arrayKay[arrayCount] = key;
        arrayValue[arrayCount] = value;
        arrayCount++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayCount; i++) {
            if ((arrayKay[i] == key) || (arrayKay[i] != null && arrayKay[i].equals(key))) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }
}
