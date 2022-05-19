package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private Object[] keysStorage;
    private Object[] valueStorage;
    private int index;

    public StorageImpl() {
        keysStorage = new Object[MAX_STORAGE_SIZE];
        valueStorage = new Object[MAX_STORAGE_SIZE];
        index = 0;
    }

    private void setData(K key, V value, int index) {
        keysStorage[index] = key;
        valueStorage[index] = value;
    }

    @Override
    public void put(K key, V value) {

        if (index == 0) {
            setData(key, value, index);
            index++;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (key == null && keysStorage[i] == null) {
                setData(key, value, i);
                return;
            }
            if (keysStorage[i] != null && keysStorage[i].equals(key)) {
                setData(key, value, i);
                return;
            }
        }
        setData(key, value, index);
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (keysStorage[i] == null && key == null) {
                return (V) valueStorage[i];
            }
            if (keysStorage[i] != null && keysStorage[i].equals(key)) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
