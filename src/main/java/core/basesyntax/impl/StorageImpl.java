package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 9;
    private int size = 0;
    private int cursor = 0;
    private K[] keyArr;
    private V[] valueArr;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyArr = (K[]) new Object[STORAGE_MAX_SIZE];
        valueArr = (V[]) new Object[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyPlaceIfContains(key);
        if (index != -1) {
            putDirectly(key, value, index);
        } else if (isFull()) {
            putDirectly(key, value, cursor);
            updateCursor();
        } else {
            putDirectly(key, value, size);
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyPlaceIfContains(key);
        return index != -1 ? valueArr[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyPlaceIfContains(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArr[i] == null) || (key != null && key.equals(keyArr[i]))) {
                return i;
            }
        }
        return -1;
    }

    private void putDirectly(K key, V value, int place) {
        keyArr[place] = key;
        valueArr[place] = value;
    }

    private boolean isFull() {
        return size == STORAGE_MAX_SIZE;
    }

    private void updateCursor() {
        cursor = (cursor + 1) % STORAGE_MAX_SIZE;
    }
}
