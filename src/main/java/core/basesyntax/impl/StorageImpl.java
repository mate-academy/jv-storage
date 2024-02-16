package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_STORAGE_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_STORAGE_SIZE];
    private K key;
    private V value;
    private int storageSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (i < storageSize && (keyArray[i] == null && key == null)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                this.setKeyAndValue(key, value, i, false);
                return;
            }
            if (storageSize == 0 && i == 0 && keyArray[i] == null) {
                this.setKeyAndValue(key, value, i, true);
                return;
            }

            if (i >= storageSize && keyArray[i] == null) {
                this.setKeyAndValue(key, value, i, true);
                return;
            }
        }
    }

    private void setKeyAndValue(K key, V value, int index, boolean incrementStorageSize) {
        if (incrementStorageSize) {
            keyArray[index] = key;
            valueArray[index] = value;
            storageSize++;
        } else {
            valueArray[index] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if ((keyArray[i] == null && key == null)) {
                return valueArray[i];
            }
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}

