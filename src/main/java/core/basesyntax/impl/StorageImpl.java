package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPABILITY = 10;

    static class StorageBox<K, V> {
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

    public StorageImpl() {
        boxes = new StorageBox[0];
    }

    @Override
    public void put(K key, V value) {
        try {
            if (boxes.length >= MAX_CAPABILITY) {
                throw new StorageOverflowError("Full storage. Impossible to write this data");
            }
            addDataInBox(key, value);
        } catch (StorageOverflowError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public V get(K key) {
        try {
            return (V) getBoxByKey(key).getValue();
        } catch (KeyContainError e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int size() {
        return boxes.length;
    }

    private void addDataInBox(K key, V value) {
        try {
            getBoxByKey(key).setValue(value);
        } catch (KeyContainError e) {
            fillStorageBox(key, value);
        }
    }

    private void fillStorageBox(K key, V value) {
        StorageBox[] newBoxes = new StorageBox[boxes.length + 1];
        for (int i = 0; i < boxes.length; i++) {
            newBoxes[i] = boxes[i];
        }
        newBoxes[boxes.length] = new StorageBox(key, value);
        boxes = newBoxes.clone();
    }

    private StorageBox getBoxByKey(K key) throws KeyContainError {
        for (StorageBox box : boxes) {
            if ((box.getKey() == key) || (box.getKey() != null && box.getKey().equals(key))) {
                return box;
            }
        }
        throw new KeyContainError("No such key");
    }
}
