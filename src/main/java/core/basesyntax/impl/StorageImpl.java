package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] storageKey;
    private V[] storageValue;

    public StorageImpl() {
        storageKey = (K[]) new Object[0];
        storageValue = (V[]) new Object[0];
    }

    @Override
    public void put(K key, V value) {
        boolean isNewKey = true;
        int rewriteIndex = -1;

        for (int i = 0; i < storageKey.length; i++) {
            if ((storageKey[i] != null && storageKey[i].equals(key))
                    || (storageKey[i] == null && key == null)) {
                isNewKey = false;
                rewriteIndex = i;

                break;
            }
        }

        if (isNewKey) {
            storageKey = expandStorageKey(storageKey);
            storageValue = expandStorageValue(storageValue);

            storageKey[storageKey.length - 1] = key;
            storageValue[storageKey.length - 1] = value;
        } else {
            storageValue[rewriteIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageKey.length; i++) {
            if ((storageKey[i] != null && storageKey[i].equals(key))
                    || (storageKey[i] == null && key == null)) {
                return storageValue[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return storageKey.length;
    }

    private K[] expandStorageKey(K[] storageKey) {
        K[] newStorageKey = (K[]) new Object[storageKey.length + 1];

        System.arraycopy(storageKey, 0, newStorageKey, 0, storageKey.length);

        return newStorageKey;
    }

    private V[] expandStorageValue(V[] storageValue) {
        V[] newStorageKey = (V[]) new Object[storageValue.length + 1];

        System.arraycopy(storageValue, 0, newStorageKey, 0, storageValue.length);

        return newStorageKey;
    }

}
