package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_SIZE = 10;
    private int resultOfNullFinder = 0;
    private int resultOfEqualFinder = 0;
    private Object[] keyObjects = new Object[ARRAY_SIZE];
    private Object[] storageObjects = new Object[ARRAY_SIZE];

    public Object[] getKeyObjects() {
        return Arrays.copyOf(keyObjects, keyObjects.length);
    }

    public Object[] getStorageObjects() {
        return Arrays.copyOf(storageObjects, storageObjects.length);
    }

    @Override
    public void put(K key, V value) {
        resultOfNullFinder = findElementAtNullIndex(key, keyObjects);
        if (resultOfNullFinder >= 0) {
            storageObjects[resultOfNullFinder] = value;
        } else {
            resultOfEqualFinder = hasEquals(key, keyObjects);
            if (resultOfEqualFinder >= 0) {
                storageObjects[resultOfEqualFinder] = value;
            } else {
                for (int i = 0; i < keyObjects.length; i++) {
                    if (keyObjects[i] == null && storageObjects[i] == null) {
                        keyObjects[i] = key;
                        storageObjects[i] = value;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public V get(K key) {
        resultOfNullFinder = findElementAtNullIndex(key, keyObjects);
        if (resultOfNullFinder >= 0) {
            return (V) (storageObjects[resultOfNullFinder]);
        } else {
            resultOfEqualFinder = hasEquals(key, keyObjects);
            return resultOfEqualFinder >= 0 ? (V) (storageObjects[resultOfEqualFinder]) : null;
        }
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

    private int findElementAtNullIndex(K key, Object[] objects) {
        if (key == null) {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int hasEquals(K key, Object [] objects) {
        for (int i = 0; i < objects.length; i++) {
            if (key.equals((objects[i]))) {
                return i;
            }
        }
        return -1;
    }
}
