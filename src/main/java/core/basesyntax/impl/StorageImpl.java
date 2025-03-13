package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V>[] storageArray;

    public StorageImpl() {
        storageArray = new Pair[] {};
    }

    @Override
    public void put(K key, V value) {
        if (hasKey(key)) {
            replacePair(new Pair<>(key, value));
            return;
        }
        Pair<K, V>[] newStorageArray = getNewStorageArray();
        newStorageArray[newStorageArray.length - 1] = new Pair<>(key, value);
        setStorageArray(newStorageArray);
    }

    @Override
    public V get(K key) {
        if (hasKey(key)) {
            return findPair(key).value;
        }
        return null;
    }

    @Override
    public int size() {
        return storageArray.length;
    }

    private void replacePair(Pair<K, V> newPair) {
        for (int i = 0; i < storageArray.length; i++) {
            if ((storageArray[i].key != null
                    && storageArray[i].key.equals(newPair.key))
                    || storageArray[i].key == newPair.key) {
                storageArray[i] = newPair;
                return;
            }
        }
    }

    private Pair<K, V>[] getNewStorageArray() {
        Pair<K, V>[] newStorageArray = new Pair[storageArray.length + 1];
        System.arraycopy(storageArray, 0, newStorageArray, 0, storageArray.length);
        return newStorageArray;
    }

    private Pair<K, V> findPair(K key) {
        for (Pair<K, V> pair: storageArray) {
            if ((pair.key != null && pair.key.equals(key)) || pair.key == key) {
                return pair;
            }
        }
        return null;
    }

    private void setStorageArray(Pair<K, V>[] storageArray) {
        this.storageArray = storageArray;
    }

    private boolean hasKey(K key) {
        for (Pair<K, V> pair: storageArray) {
            if ((pair.key != null && pair.key.equals(key)) || pair.key == key) {
                return true;
            }
        }
        return false;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
