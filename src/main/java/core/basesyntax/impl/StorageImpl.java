package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final String INDEX_OF_BOUND_EXCEPTION_MESSAGE = "Storage is full and has "
            + MAX_ITEMS_NUMBER + " elements.You cant add more elements in it.";
    private int size = 0;
    private Box<K, V>[] boxes;

    public StorageImpl() {
        boxes = new Box[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        sizeCheck();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, boxes[i].key)) {
                boxes[i].setValue(value);
                return;
            }
        }
        boxes[size] = new Box<>(key, value);
        size++;
    }

    private void sizeCheck() {
        if (size == boxes.length) {
            throw new IndexOutOfBoundsException(INDEX_OF_BOUND_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, boxes[i].key)) {
                return boxes[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Box<K, V> {
        private K key;
        private V value;

        private Box(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private void setValue(V value) {
            this.value = value;
        }
    }
}
