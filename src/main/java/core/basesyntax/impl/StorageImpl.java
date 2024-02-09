package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int MAX_SIZE = 10;
    public static final int KEY_VALUE = 2;
    public Object[][] storage = new Object[MAX_SIZE][KEY_VALUE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (storage[i][0] == null && storage[i][1] != null && key == null) {
                storage[i][1] = value;
                break;
            }
            if (storage[i][0] != null && storage[i][0].equals(key)) {
                storage[i][1] = value;
                break;
            }
            if ((storage[i][0] == null) && (storage[i][1] == null)) {
                storage[i][0] = key;
                storage[i][1] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {

        if (size() > MAX_SIZE) {
            return null;
        }
        for (int j = 0; j < MAX_SIZE; j++) {
            if (storage[j][0] == null && storage[j][1] != null && key == null) {
                return (V) storage[j][1];
            }
            if (storage[j][0] != null && storage[j][0].equals(key)) {
                return (V) storage[j][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (Object[] o : storage) {
            if (o[1] != null) {
                count++;
            }
        }
        return count;
    }
}
