package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private int nextIndex = 0;
    private int indexKey;
    private final KeyValueBox<K, V>[] boxArray = new KeyValueBox[MAX_ITEMS];

    private boolean checkTheKey(KeyValueBox<K, V> box) {
        for (int i = 0; i < boxArray.length; i++) {
            if (boxArray[i] != null && boxArray[i].getKey() == null) {
                return boxArray[i].getKey() == box.getKey();
            }
            if (boxArray[i] != null && boxArray[i].getKey().equals(box.getKey())) {
                indexKey = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        KeyValueBox<K, V> newBox = new KeyValueBox<>(key, value);
        if (checkTheKey(newBox)) {
            boxArray[indexKey] = newBox;
        } else {
            boxArray[nextIndex] = newBox;
            nextIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (KeyValueBox<K, V> box: boxArray) {
            if (box != null) {
                if (box.getKey() == null && key == null) {
                    return box.getValue();
                } else if (box.getKey() == null && key != null) {
                    continue;
                } else if (box.getKey() != null && box.getKey().equals(key)) {
                    return box.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int lengthCounter = 0;
        for (KeyValueBox<K, V> box: boxArray) {
            if (box != null) {
                lengthCounter++;
            }
        }
        return lengthCounter;
    }
}
