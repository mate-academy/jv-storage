
package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) Array.newInstance(Object.class, STORAGE_LENGTH);
        this.values = (V[]) Array.newInstance(Object.class, STORAGE_LENGTH);
    }

    @Override
    public void put(K key, V value) {
        if (checkRepeatableKeys(key, value)) {
            return;
        }
        if (size < STORAGE_LENGTH) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    private boolean checkRepeatableKeys(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                values[i] = value;
                return true;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                return values[i];
            } else if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
