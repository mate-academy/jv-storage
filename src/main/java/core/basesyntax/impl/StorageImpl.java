package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUM_VALUE = 10;
    private Pair<K, V>[] storageArray;
    private int size;

    public StorageImpl() {
        this.storageArray = new Pair[MAX_NUM_VALUE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_NUM_VALUE) {
            throw new RuntimeException("Storage is full!");
        }

        for (int i = 0; i < MAX_NUM_VALUE; i++) {
            @SuppressWarnings("unchecked")
            Pair<K, V> pair = storageArray[i];
            if (pair != null) {
                if ((key == pair.getKey())
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
            Pair<K, V> pair = storageArray[i];
            if ((key == pair.getKey())
                    || (key != null && key.equals(pair.getKey()))) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
