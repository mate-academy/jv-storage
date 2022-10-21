
package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_INDEX_STORAGE = 10;
    private int size;
    private K [] keyStorage;
    private V [] valueStorage;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_INDEX_STORAGE];
        valueStorage = (V[]) new Object[MAX_INDEX_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || (key != null && key.equals(keyStorage[i]))) {
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyStorage[i] == key || (key != null && key.equals(keyStorage[i]))) {
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
