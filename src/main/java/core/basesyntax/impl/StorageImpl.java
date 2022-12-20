package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int VALUE_OF_NULL = -1;
    private final Object[] keyStorage;
    private final Object[] valueStorage;
    private int size = 0;

    public StorageImpl() {
        keyStorage = new Object[MAX_CAPACITY];
        valueStorage = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] != null) {
                if (keyStorage[i].equals(VALUE_OF_NULL) && key == null) {
                    valueStorage[i] = value;
                    size--;
                    break;
                } else if (keyStorage[i].equals(key)) {
                    valueStorage[i] = value;
                    size--;
                    break;
                }
            }
        }
        for (int i = 0; i < keyStorage.length; i++) {
            if (key == null && keyStorage[i] == null && valueStorage[i] == null) {
                keyStorage[i] = VALUE_OF_NULL;
                valueStorage[i] = value;
                size++;
                break;
            } else if (keyStorage[i] == null && valueStorage[i] == null) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] != null) {
                if (keyStorage[i].equals(VALUE_OF_NULL) && key == null) {
                    return (V) valueStorage[i];
                } else if (keyStorage[i].equals(key)) {
                    return (V) valueStorage[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
