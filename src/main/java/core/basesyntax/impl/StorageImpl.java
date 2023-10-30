package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.TypedArray;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int freeIndex;
    private final TypedArray<StorageItem> storageItems;

    public StorageImpl() {
        storageItems = new TypedArray<>(STORAGE_SIZE);
    }

    @Override
    public void put(K key, V value) {
        int elIndex = indexOf(key);
        if (elIndex >= 0) {
            StorageItem element = storageItems.getElement(elIndex);
            element.setValue(value);
            storageItems.setElement(elIndex, element);
            return;
        }
        storageItems.setElement(freeIndex, new StorageItem(key, value));
        freeIndex++;
    }

    @Override
    public V get(K key) {
        int elIndex = indexOf(key);
        if (elIndex >= 0) {
            return storageItems.getElement(elIndex).getValue();
        }
        return null;
    }

    private int indexOf(K key) {
        for (int index = 0; index < size(); index++) {
            StorageItem element = storageItems.getElement(index);
            if (element == null) {
                return -1;
            }
            if (element.getKey() == null && key == null) {
                return index;
            }
            if (element.getKey() != null && element.getKey().equals(key)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return freeIndex;
    }

    private class StorageItem {
        private K key;
        private V value;

        StorageItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public String toString() {
            return "key => " + key.toString() + " value => " + value.toString();
        }
    }
}
