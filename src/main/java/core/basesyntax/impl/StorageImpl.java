package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE_PAIR = 10;
    private Pair<K, V>[] storageArray;
    private int size;

    public StorageImpl() {
        storageArray = new Pair[MAX_SIZE_PAIR];
    }

    @Override
    public void put(K key, V value) {
        if (size == storageArray.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "Max capacity of array is 10! You cant add more items");
        }
        for (int i = 0; i < size; ++i) {
            if (equals(key, storageArray[i].getKey())) {
                storageArray[i] = new Pair<>(key, value);
                return;
            } else if (key == null && storageArray[i].getKey() == null) {
                storageArray[i] = new Pair<>(key, value);
                return;
            }
        }
        storageArray[size] = new Pair<>(key, value);
        ++size;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; ++i) {
            if (equals(key, storageArray[i].getKey())) {
                return storageArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean equals(K key, K keySecond) {
        return key == keySecond || key != null && key.equals(keySecond);
    }
}
