package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int DEFAULT_SIZE_PAIR = 10;
    private Pair<K, V>[] storageArray = new Pair[DEFAULT_SIZE_PAIR];
    private int size;

    public Pair<K, V>[] increaseArray(Pair<K, V>[] oldArray) {
        int newSize = size * 2;
        Pair<K, V>[] newArray = new Pair[newSize];
        for (int i = 0; i < size; ++i) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    @Override
    public void put(K key, V value) {
        if (size == storageArray.length) {
            storageArray = increaseArray(storageArray);
        }
        for (int i = 0; i < size; ++i) {
            if (key != null && storageArray[i].getKey() != null) {
                if (storageArray[i].getKey().equals(key)) {
                    storageArray[i] = new Pair<>(key, value);
                    return;
                }
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
            if (key != null && storageArray[i].getKey() != null) {
                if (storageArray[i].getKey().equals(key)) {
                    return storageArray[i].getValue();
                }
            } else if ((key == null && storageArray[i].getKey() == null)
                    && storageArray[i].getValue() != null) {
                return storageArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
