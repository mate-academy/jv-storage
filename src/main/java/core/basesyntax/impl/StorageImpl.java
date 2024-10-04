package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private Object[] keyObjects = new Object[ARRAY_SIZE];
    private Object[] storageObjects = new Object[ARRAY_SIZE];

    @Override
    public Object[] getKeyObjects() {
        return Arrays.copyOf(keyObjects, keyObjects.length);
    }

    @Override
    public Object[] getStorageObjects() {
        return Arrays.copyOf(storageObjects, storageObjects.length);
    }

    @Override
    public void put(K key, V value) {
        int resultOfIndexFinder = 0;
        resultOfIndexFinder = findByIndex(key, keyObjects);

        if (resultOfIndexFinder >= 0) {
            storageObjects[resultOfIndexFinder] = value;
        } else {
            resultOfIndexFinder = defineEmptyCell();
            keyObjects[resultOfIndexFinder] = key;
            storageObjects[resultOfIndexFinder] = value;
        }
    }

    @Override
    public V get(K key) {
        int resultOfIndexFinder = 0;
        resultOfIndexFinder = findByIndex(key, keyObjects);
        return resultOfIndexFinder >= 0 ? (V) (storageObjects[resultOfIndexFinder]) : null;
    }

    @Override
    public int size() {
        int index = 0;
        for (int i = 0; i < storageObjects.length; i++) {
            if (keyObjects[i] == null && storageObjects[i] == null) {
                return i;
            }
            index = ARRAY_SIZE;
        }
        return index;
    }

    private int findByIndex(K key, Object[] objects) {
        int index = 0;
        if (key == null) {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    return i;
                }
            }
        }
        index = findIndexOfKey(key, objects);
        return index >= 0 ? index : -1;
    }

    private int findIndexOfKey(K key, Object [] objects) {
        for (int i = 0; i < objects.length; i++) {
            if (key.equals((objects[i]))) {
                return i;
            }
        }
        return -1;
    }

    private int defineEmptyCell() {
        for (int i = 0; i < keyObjects.length; i++) {
            if (keyObjects[i] == null && storageObjects[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
