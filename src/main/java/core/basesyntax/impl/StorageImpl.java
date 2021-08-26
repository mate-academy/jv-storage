package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final double GROW_COEFFICIENT = 1.5;
    private int size = 0;
    private Box<K, V>[] boxes;

    public StorageImpl() {
        boxes = new Box[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, boxes[i].key)) {
                boxes[i].setValue(value);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            boxes[size++] = new Box<>(key, value);
        }
        grow();
    }

    private void grow() {
        if (size == boxes.length) {
            Box<K, V>[] resizedBoxes = new Box[(int) (size * GROW_COEFFICIENT)];
            System.arraycopy(boxes, 0, resizedBoxes, 0, boxes.length);
            boxes = resizedBoxes;
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

    static class Box<K, V> {
        private K key;
        private V value;

        public Box(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
