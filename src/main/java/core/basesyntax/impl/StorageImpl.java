package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_ARRAY_LENGTH = 10;
    private final K[] keyStorage = (K[]) new Object[STORAGE_ARRAY_LENGTH];
    private final V[] valueStorage = (V[]) new Object[STORAGE_ARRAY_LENGTH];

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
        for (K k: keyStorage) {
            if (k == null && valueStorage[count] == null) {
                break;
            }
            count++;
        }
        return count;
    }

    public int getIndex(K key) {
        int index = 0;
        for (K k : keyStorage) {
            if (k == null && valueStorage[index] == null
                    || (key == k || (key != null && key.equals(k)))) {
                break;
            }
            index++;
        }
        return index;
    }
}

