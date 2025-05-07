package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    public StorageImpl() {

        keyStorage = (K[])(new Object[MAX_SIZE]);
        valueStorage = (V[])(new Object[MAX_SIZE]);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyStorage[i] == null && key == null
                    || keyStorage[i] != null && keyStorage[i].equals(key)) {
                valueStorage[i] = value;
                return;
            }
        }
        valueStorage[size] = value;
        keyStorage[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] == null && key == null
                    || (keyStorage[i] == key || (keyStorage[i] != null
                    && keyStorage[i].equals(key)))) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
