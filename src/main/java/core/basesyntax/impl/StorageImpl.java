package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K,V>[] storageArray;
    private int size;

    public StorageImpl() {
        this.storageArray = new Pair[MAX_ITEMS_NUMBER];
        this.size = 0;
    }

    public void put(K key, V value) {

        int index = indexOfKey(key);
        if (index >= 0) {
            storageArray[index].setValue(value);
        } else {
            storageArray[size++] = new Pair<>(key, value);
        }
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keysAreEqual(key, storageArray[i].key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean keysAreEqual(K key1, K key2) {
        if (key1 == null) {
            return key2 == null;
        } else {
            return key1.equals(key2);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Pair<K, V> pair = storageArray[i];
            if (keysAreEqual(key, pair.key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
