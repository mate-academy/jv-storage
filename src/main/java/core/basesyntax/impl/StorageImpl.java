package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size = 0;
    private Box<K, V>[] boxes;

    public StorageImpl() {
        boxes = new Box[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (isEmpty()) {
            putElementWithNotExistingKey(key, value);
        } else {
            if (containsKey(key)) {
                putElementWithExistingKey(key, value);
            } else {
                putElementWithNotExistingKey(key, value);
            }
        }
    }

    private void putElementWithExistingKey(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, boxes[i].key)) {
                boxes[i].setValue(value);
            }
        }
    }

    private void putElementWithNotExistingKey(K key, V value) {
        boxes[size++] = new Box<>(key, value);
    }

    private boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, boxes[i].key)) {
                return true;
            }
        }
        return false;
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

    public boolean isEmpty() {
        return size == 0;
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
