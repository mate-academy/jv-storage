package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private K key;
    private V value;
    private final StorageImpl<K, V>[] boxes;
    private int size;

    public StorageImpl() {
        boxes = new StorageImpl[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        if (this.getStorage(key) == null) {
            if (size == MAX_VALUE) {
                throw new FullStorageException();
            }
            StorageImpl<K, V> box = new StorageImpl<>();
            box.value = value;
            box.key = key;
            boxes[size] = box;
            size++;
        } else {
            getStorage(key).value = value;
        }
    }

    @Override
    public V get(K key) {
        StorageImpl<K, V> box = getStorage(key);
        if (box != null) {
            return box.value;
        }
        return null;
    }

    private StorageImpl<K, V> getStorage(K key) {
        for (int i = 0; i < size; i++) {
            if (boxes[i].key != null && boxes[i].key.equals(key) || key == boxes[i].key) {
                return boxes[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
