package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private static final int INDEX_ABSENT = -1;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) (new Object[10]);
        values = (V[]) (new Object[10]);
    }

    @Override
    public void put(K key, V value) {
        int index;
        if (key == null) {
            index = getIndexWithNullKey();
            if (index != INDEX_ABSENT) {
                values[index] = value;
                return;
            }
        }
        index = getIndexByKey(key);
        if (index != INDEX_ABSENT) {
            keys[index] = key;
            values[index] = value;
            return;
        }
        if (size() == STORAGE_CAPACITY) {
            System.out.println("storage overloaded");
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        int index;
        if (key == null) {
            index = getIndexWithNullKey();
            if (index != INDEX_ABSENT) {
                return values[index];
            }
            return null;
        }
        index = getIndexByKey(key);
        if (index != INDEX_ABSENT) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        int index = getIndexWithNullKey();
        if (index != INDEX_ABSENT) {
            count++;
        }
        for (K key : keys) {
            if (key != null) {
                count++;
            }
        }
        return count;
    }

    private int getIndexWithNullKey() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] != null) {
                return i;
            }
        }
        return INDEX_ABSENT;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return INDEX_ABSENT;
    }
}
