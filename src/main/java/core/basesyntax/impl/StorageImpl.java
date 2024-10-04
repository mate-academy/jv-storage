package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keyObjects = new Object[10];
    private Object[] storageObjects = new Object[10];

    public Object[] getKeyObjects() {
        return keyObjects;
    }

    public void setKeyObjects(Object[] keyObjects) {
        this.keyObjects = keyObjects;
    }

    public Object[] getStorageObjects() {
        return storageObjects;
    }

    public void setStorageObjects(Object[] storageObjects) {
        this.storageObjects = storageObjects;
    }

    @Override
    public void put(K key, V value) {
        if (findElementAtNullIndex(key, keyObjects) >= 0) {
            storageObjects[findElementAtNullIndex(key, keyObjects)] = value;
        } else if (hasEquals(key, keyObjects) >= 0) {
            storageObjects[hasEquals(key, keyObjects)] = value;
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

    @Override
    public V get(K key) {
        if (findElementAtNullIndex(key, keyObjects) >= 0) {
            return (V) (storageObjects[findElementAtNullIndex(key, keyObjects)]);
        } else if (hasEquals(key, keyObjects) >= 0) {
            return (V) (storageObjects[hasEquals(key, keyObjects)]);
        }
        return null;
    }

    @Override
    public int size() {
        int index = 0;
        for (int i = 0; i < storageObjects.length; i++) {
            if (keyObjects[i] == null
                    && storageObjects[i] == null) {
                return i;
            }
            index = 10;
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
