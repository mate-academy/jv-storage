package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LIMIT_OF_ARRAY = 10;
    private static final int VALUE_OF_NULL = -1;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private final Object[][] obj = new Object[LIMIT_OF_ARRAY][2];
    private int size = 0;

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < obj.length; i++) {
            if (obj[i][KEY_INDEX] != null) {
                if (obj[i][KEY_INDEX].equals(VALUE_OF_NULL) && key == null) {
                    obj[i][VALUE_INDEX] = value;
                    size--;
                    break;
                }
                if (obj[i][KEY_INDEX].equals(key)) {
                    obj[i][VALUE_INDEX] = value;
                    size--;
                    break;
                }
            }
        }
        for (int i = 0; i < obj.length; i++) {
            if (key == null && obj[i][KEY_INDEX] == null && obj[i][VALUE_INDEX] == null) {
                obj[i][KEY_INDEX] = VALUE_OF_NULL;
                obj[i][VALUE_INDEX] = value;
                size++;
                break;
            }
            if (obj[i][KEY_INDEX] == null && obj[i][VALUE_INDEX] == null) {
                obj[i][KEY_INDEX] = key;
                obj[i][VALUE_INDEX] = value;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Object[] objects : obj) {
            if (objects[KEY_INDEX] != null) {
                if (objects[KEY_INDEX].equals(VALUE_OF_NULL) && key == null) {
                    return (V) objects[VALUE_INDEX];
                }
                if (objects[KEY_INDEX].equals(key)) {
                    return (V) objects[VALUE_INDEX];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
