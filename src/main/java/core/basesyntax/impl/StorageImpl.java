package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Object[] keysStorage = new Object[10];
    private final Object[] itemsStorage = new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keysStorage.length; i++) {
            if ((key == null && keysStorage[i] == null)
                    || (key != null && key.equals(keysStorage[i]))) {
                itemsStorage[i] = value;
                return;
            }
        }

        for (int i = 0; i < keysStorage.length; i++) {
            if (keysStorage[i] == null && itemsStorage[i] == null) {
                keysStorage[i] = key;
                itemsStorage[i] = value;
                return;
            }
        }

        throw new RuntimeException("Storage is full");
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysStorage.length; i++) {
            if (key == null && keysStorage[i] == null) {
                return (V) itemsStorage[i];
            }
            if (key != null && key.equals(keysStorage[i])) {
                return (V) itemsStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (Object key : keysStorage) {
            if (key != null) {
                count++;
            }
        }
        return count;
    }
}
