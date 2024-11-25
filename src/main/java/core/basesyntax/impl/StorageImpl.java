package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] storageOfKeys = (K[])(new Object[10]);
    private final V[] storageOfValues = (V[])(new Object[10]);
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqualKey(storageOfKeys[i], key)) {
                storageOfValues[i] = value;
                return;
            }
        }
        storageOfKeys[size] = key;
        storageOfValues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqualKey(storageOfKeys[i], key)) {
                return storageOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEqualKey(K keyInArray, K keyInput) {
        return keyInput == keyInArray
               || (keyInArray != null && keyInArray.equals(keyInput));
    }
}
