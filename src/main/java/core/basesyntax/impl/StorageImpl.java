package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;
    private int arrayCountForKay;
    private int arrayCountForValue;
    private Object[] arrayKay;
    private Object[] arrayValue;

    public <K, V> StorageImpl() {
        arrayKay = new Object[ARRAY_SIZE];
        arrayValue = new Object[ARRAY_SIZE];
        arrayCountForKay = 0;
        arrayCountForValue = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null && value != null) {
            arrayKay[arrayCountForKay++] = null;
            arrayValue[arrayCountForValue++] = value;
            return;
        }
        for (int i = 0; i < arrayKay.length; i++) {
            if (arrayKay[i] == key) {
                arrayValue[i] = value;
                break;
            }
        }
        arrayKay[arrayCountForKay++] = key;
        arrayValue[arrayCountForValue++] = value;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < arrayKay.length; i++) {
                if (arrayKay[i] == null && arrayValue[i] != null) {
                    return (V) arrayValue[i];
                }
            }
        } else {
            for (int i = 0; i < arrayKay.length; i++) {
                if (key.equals(arrayKay[i])) {
                    return (V) arrayValue[i];
                }
            }
        }
        return null;
    }
}
