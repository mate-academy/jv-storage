package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private final K[] keyStorage = (K[]) new Object[ARRAY_LENGTH];
    private final V[] valueStorage = (V[]) new Object[ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] == null && valueStorage[i] == null
                    || key == null && keyStorage[i] == null && !valueStorage[i].equals(value)
                    || keyStorage[i] != null && keyStorage[i].equals(key)) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        if (key == null) {
            for (int i = 0; i < keyStorage.length; i++) {
                if (keyStorage[i] == null && valueStorage[i] != null) {
                    return valueStorage[i];
                }
            }
        }
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] != null && keyStorage[i].equals(key)) {
                index = i;
            }
        }
        return valueStorage[index];
    }

    @Override
    public int size() {
        int count = 0;
        for (V element : valueStorage) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }
}
