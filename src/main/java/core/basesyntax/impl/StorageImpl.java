package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_VOLUME = 10;
    private final Object[] keyArray = new Object[MAX_STORAGE_VOLUME];
    private final Object[] valueArray = new Object[MAX_STORAGE_VOLUME];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if ((keyArray[i] == null && valueArray[i] == null)
                    || (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key)))) {
                keyArray[i] = key;
                valueArray[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key))) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < valueArray.length; i++) {
            if (valueArray[i] == null) {
                return i;
            }
        }
        return valueArray.length;
    }
}
