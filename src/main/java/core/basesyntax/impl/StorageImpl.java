package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private Object[][] items = new Object[STORAGE_MAX_SIZE][2];

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        int existingKey = -1;
        int firstFreeSpot = -1;
        for (int i = 0; i < STORAGE_MAX_SIZE; i++) {
            if (keyMatch(key, items[i][0]) || bothNulls(key, items[i][0])) {
                existingKey = i;
                break;
            }
            if (bothNulls(items[i][0], items[i][1]) && firstFreeSpot == -1) {
                firstFreeSpot = i;
            }
        }
        if (existingKey == -1) {
            items[firstFreeSpot][0] = key;
            items[firstFreeSpot][1] = value;
        } else {
            items[existingKey][0] = key;
            items[existingKey][1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_MAX_SIZE; i++) {
            if (keyMatch(key, items[i][0]) || bothNulls(key, items[i][0])) {
                return (V)items[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < STORAGE_MAX_SIZE; i++) {
            if (!bothNulls(items[i][0], items[i][1])) {
                counter++;
            }
        }
        return counter;
    }

    private boolean bothNulls(Object value1, Object value2) {
        return value1 == null && value2 == null;
    }

    private boolean keyMatch(Object key1, Object key2) {
        return key1 != null && key1.equals(key2);
    }
}
