package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUM_VALUE = 10;
    private final Object[] storageArray = new Object[MAX_NUM_VALUE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size > MAX_NUM_VALUE) {
            throw new RuntimeException("Storage is full!");
        }

        for (int i = 0; i < MAX_NUM_VALUE; i++) {
            @SuppressWarnings("unchecked")
            Pair<K, V> pair = (Pair<K, V>) storageArray[i];
            if (pair != null) {
                if ((key == null && pair.getKey() == null)
                        || (key != null && key.equals(pair.getKey()))) {
                    pair.setValue(value);
                    return;
                }
            }
        }
        storageArray[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            Pair<K, V> pair = (Pair<K, V>) storageArray[i];
            if (pair != null) {
                if ((key == null && pair.getKey() == null)
                        || (key != null && key.equals(pair.getKey()))) {
                    return pair.getValue();
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
