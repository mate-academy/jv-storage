package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 9;
    private static int size = 0;
    private static int cursor = 0;
    private K[] keyArr;
    private V[] valueArr;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyArr = (K[]) new Object[STORAGE_MAX_SIZE];
        valueArr = (V[]) new Object[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        validateKey(key);
        if (getKeyPlaceIfContains(key) != -1) {
            putDirectly(key, value, getKeyPlaceIfContains(key));
            size++;
        } else if (isFull()) {
            putDirectly(key, value, cursor);
            updateCursor();
        } else {
            putDirectly(key, value, size());
        }
    }

    @Override
    public V get(K key) {
        return valueArr[getKeyPlaceIfContains(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyPlaceIfContains(K key) {
        for (int i = 0; i < size(); i++) {
            if (keyArr[i] == key) {
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
        return size() == STORAGE_MAX_SIZE;
    }

    private void updateCursor() {
        if (cursor == STORAGE_MAX_SIZE) {
            cursor = 0;
        } else {
            cursor++;
        }
    }

    private boolean validateKey (K key){
        if(key == null){
            throw new RuntimeException("Key cannot be null!");
        }
        return true;
    }
}
