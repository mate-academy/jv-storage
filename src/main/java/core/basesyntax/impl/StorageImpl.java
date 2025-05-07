package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPABILITY = 10;

    private static class StorageBox<K, V> {
        private final K key;
        private V value;

        public StorageBox(K key, V value) {
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
    }

    private StorageBox[] boxes;
    private int size;

    public StorageImpl() {
        boxes = new StorageBox[MAX_CAPABILITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        checkBoxSize();
        try {
            getBoxByKey(key).value = value;
        } catch (KeyContainException e) {
            boxes[size] = new StorageBox(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        try {
            return (V) getBoxByKey(key).getValue();
        } catch (KeyContainException e) {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private StorageBox getBoxByKey(K key) throws KeyContainException {
        for (int i = 0; i < size; i++) {
            if ((boxes[i].getKey() == key)
                    || (boxes[i].getKey() != null && boxes[i].getKey().equals(key))) {
                return boxes[i];
            }
        }
        throw new KeyContainException("No such key");
    }

    private void checkBoxSize() {
        if (size == MAX_CAPABILITY) {
            throw new StorageOverflowException("Full storage. Impossible to write this data");
        }
    }
}
