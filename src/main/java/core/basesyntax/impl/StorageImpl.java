package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private StorageItem<K, V> [] storage = new StorageItem[10];
    private int counter = 0;

    @Override
    public void put(K key, V value) {
        boolean isNewItem = true;

        for (int i = 0; i < storage.length; i++) {
            StorageItem<K,V> item = storage[i];

            if (isKeysEquals(item, key)) {
                item.value = value;
                isNewItem = false;
                break;
            }
        }

        if (isNewItem) {
            storage[counter] = new StorageItem<>(key,value);
            counter++;
        }
    }

    @Override
    public V get(K key) {
        for (StorageItem<K,V> item : storage) {
            if (isKeysEquals(item, key)) {
                return item.value;
            }
        }
        return null;
    }

    private boolean isKeysEquals(StorageItem<K,V> item, K key) {
        return item != null
                && (item.key == null && key == null
                || item.key != null && item.key.equals(key));
    }

    @Override
     public int size() {
        int length = 0;

        for (StorageItem item : storage) {
            if (item != null) {
                length++;
            }
        }

        return length;
    }

    private class StorageItem<K, V> {
        private K key;
        private V value;

        public StorageItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }
    }
}
