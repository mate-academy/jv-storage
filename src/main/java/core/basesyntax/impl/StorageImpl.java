package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keyItem;
    private V[] itemPair;
    private int size;

    public StorageImpl() {
        keyItem = (K[]) new Object[MAX_STORAGE_SIZE];
        itemPair = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    private boolean isKeyTheSame(K key, K[] keyItem, int i) {
        boolean isKeyNull = (key == null && keyItem[i] == null);
        boolean isKeyNotNull = (key != null && key.equals(keyItem[i]));
        return isKeyNull || isKeyNotNull;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            boolean isKeyTheSame = isKeyTheSame(key, keyItem, i);
            if (isKeyTheSame) {
                itemPair[i] = value;
                size--;
            }
        }
        keyItem[size] = key;
        itemPair[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            boolean isKeyTheSame = isKeyTheSame(key, keyItem, i);
            if (isKeyTheSame) {
                return itemPair[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
