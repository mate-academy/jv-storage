package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private boolean haveNull = false;
    private V nullValue;
    private int size = 0;
    private final Object[] keys = new Object[MAX_STORAGE_SIZE];
    private final Object[] values = new Object[MAX_STORAGE_SIZE];

    public StorageImpl() {

    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            nullValue = value;
            haveNull = true;
            return;
        }
        for (int i = 0; i < MAX_STORAGE_SIZE - (haveNull ? 1 : 0); i++) {
            if (keys[i] == null || keys[i].equals(key)) {
                size += keys[i] == null ? 1 : 0;
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null && haveNull) {
            return nullValue;
        }
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size + (haveNull ? 1 : 0);
    }
}
