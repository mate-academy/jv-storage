package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private int lastElement;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.size = 0;
        this.lastElement = -1;
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    private void changeExistingKeyValue(K key, V value) {
        int keyIndex = getIndex(key);
        values[keyIndex] = value;
    }

    private boolean isKeyExist(K key) {
        if (size == 0 || lastElement == -1) {
            return false;
        }
        if (key == null && lastElement >= 0) {
            for (int i = 0; i <= lastElement; i++) {
                if (keys[i] == null) {
                    return true;
                }
            }
            return false;
        }
        boolean finded = false;
        for (K existingKey : keys) {
            if (key.equals(existingKey)) {
                finded = true;
                break;
            }
        }
        return finded;
    }

    private int getIndex(K key) {
        if (isKeyExist(key)) {
            int index = 0;
            for (int i = 0; i <= lastElement; i++) {
                if (key == null && keys[i] == null) {
                    break;
                } else if (keys[i] != null && keys[i].equals(key)) {
                    break;
                }
                index++;
            }
            return index;
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (isKeyExist(key)) {
            changeExistingKeyValue(key, value);
            return;
        }
        keys[lastElement + 1] = key;
        values[lastElement + 1] = value;
        lastElement++;
        size++;
    }

    @Override
    public V get(K key) {
        return isKeyExist(key)
               ? values[getIndex(key)]
               : null;
    }

    @Override
    public int size() {
        return size;
    }
}
