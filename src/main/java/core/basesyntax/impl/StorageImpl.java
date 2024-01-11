package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_ARRAY_LENGTH = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int size;

    public StorageImpl() {
        this.keyStorage = (K[]) new Object[STORAGE_ARRAY_LENGTH];
        this.valueStorage = (V[]) new Object[STORAGE_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        keyStorage[index] = key;
        valueStorage[index] = value;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return valueStorage[index];
    }

    @Override
    public int size() {
        int count = 0;
        for (K keyInStorage: keyStorage) {
            if (keyInStorage == null && valueStorage[count] == null) {
                break;
            }
            count++;
        }
        this.size = count;
        return size;
    }

    public int getIndex(K key) {
        int index = 0;
        for (K keyInStorage : keyStorage) {
            if (keyInStorage == null && valueStorage[index] == null
                    || (key == keyInStorage || (key != null && key.equals(keyInStorage)))) {
                break;
            }
            index++;
        }
        return index;
    }
}

