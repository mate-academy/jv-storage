package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private K key;
    private V value;
    private final StorageImpl<K, V>[] boxes;

    public StorageImpl() {
        boxes = new StorageImpl[10];
    }

    @Override
    public void put(K key, V value) {
        if (this.getStorage(key) == null) {
            StorageImpl<K, V> box = new StorageImpl<>();
            box.setValue(value);
            box.setKey(key);
            boxes[findEmptyPlace()] = box;
        } else {
            getStorage(key).setValue(value);
        }
    }

    private int findEmptyPlace() {
        for (int i = 0; i < MAX_VALUE; i++) {
            if (boxes[i] == null) {
                return i;
            }
        }
        throw new FullStorageException();
    }

    @Override
    public V get(K key) {
        StorageImpl<K, V> box = getStorage(key);
        if (box == null) {
            return null;
        } else {
            return box.getValue();
        }
    }

    private StorageImpl<K, V> getStorage(K key) {
        for (int i = 0; i < findEmptyPlace(); i++) {
            if (boxes[i] != null && boxes[i].getKey() == null && key == null) {
                return boxes[i];
            }
            if (boxes[i] != null && boxes[i].getKey() != null && boxes[i].key.equals(key)) {
                return boxes[i];
            }
        }
        return null;
    }

    private K getKey() {
        return key;
    }

    private V getValue() {
        return value;
    }

    private void setKey(K key) {
        this.key = key;
    }

    private void setValue(V value) {
        this.value = value;
    }

    @Override
    public int size() {
        return findEmptyPlace();
    }
}
