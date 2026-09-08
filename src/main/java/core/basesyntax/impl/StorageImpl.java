package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    @SuppressWarnings("unchecked")
    private final Box<K, V>[] boxes = (Box<K, V>[]) new Box[MAX_SIZE];

    private int size;

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index != -1) {
            boxes[index].setValue(value);
        } else {
            if (size == MAX_SIZE) {
                throw new RuntimeException("The storage is full");
            }
            boxes[size] = new Box<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        if (index == -1) {
            return null;
        }
        return boxes[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < boxes.length && boxes[i] != null; i++) {
            if (this.boxes[i].equalsKey(key)) {
                return i;
            }
        }
        return -1;
    }
}
