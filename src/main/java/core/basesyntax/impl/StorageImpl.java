package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object [] massivKey;
    private Object [] massivValue;
    private int size;

    public StorageImpl() {
        massivKey = new Object[MAX_ITEMS_NUMBER];
        massivValue = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((massivKey[i] == key) || (massivKey[i] != null && massivKey[i].equals(key))) {
                massivKey[i] = key;
                massivValue[i] = value;
                return;
            }
        }
        massivKey[size] = key;
        massivValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((massivKey[i] == key) || (massivKey[i] != null && massivKey[i].equals(key))) {
                return (V) massivValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
