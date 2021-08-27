package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_BOX_NUMBER = 10;
    private static final int MAX_KEY_NUMBER = 10;

    private V[] boxes;
    private K[] keys;

    public StorageImpl() {
        this.boxes = (V[]) new Object[MAX_BOX_NUMBER];
        this.keys = (K[]) new Object[MAX_KEY_NUMBER];
    }

    public V[] getBoxes() {
        return boxes;
    }

    public K[] getKeys() {
        return keys;
    }

    @Override
    public void put(K key, V value) {
        if (isKeyExistInDB(key)) {
            boxes[indexOf(keys, key)] = value;
        }
        if (!isKeyExistInDB(key)) {
            putInEmptyCell(key, value);
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                value = boxes[i];
                break;
            }
            if (key == null && keys[i] == null) {
                value = boxes[i];
                break;
            }
        }
        return value;
    }

    @Override
    public int size() {
        if (this.boxes == null && this.keys == null) {
            return 0;
        }
        int size = 0;
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < boxes.length; j++) {
                if (boxes[i] != null || keys[i] != null) {
                    size++;
                    break;
                }
            }
        }
        return size;
    }

    private void putInEmptyCell(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            int index = 0;
            for (int j = 0; j < boxes.length; j++) {
                if (keys[i] == null && boxes[i] == null) {
                    keys[i] = key;
                    boxes[i] = value;
                    index++;
                    break;
                }
                i++;
            }
            if (index != 0) {
                break;
            }
        }
    }

    public int indexOf(Object[] objects, Object value) {
        if (objects == null) {
            throw new RuntimeException("Array can not be null");
        }
        for (int i = 0; i < objects.length; i++) {
            if (value == null && objects[i] == value && boxes[i] != null
                    || value != null && objects[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isKeyExistInDB(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null && key == keys[i] && boxes[i] != null
                    || key != null && key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }
}
