package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private static final int START_INDEX_LENGTH = -1;
    private static int sizeIndex;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
        values = (V[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
        sizeIndex = START_INDEX_LENGTH;
    }

    @Override
    public void put(K key, V value) {
        if (findKey(key) == -1) {
            sizeIndex += 1;
            sizeIndex = (values[sizeIndex] == null) ? sizeIndex : sizeIndex + 1;
            keys[sizeIndex] = key;
            values[sizeIndex] = value;
        } else {
            values[findKey(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return (findKey(key) == -1) ? null : values[findKey(key)];
    }

    @Override
    public int size() {
        for (int i = 0; i < values.length; i++) {
            if (keys[i] == null && values[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private int findKey(K key) {
        Integer keyIndex = -1;
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
                return keyIndex = i;
            }
        }
        return keyIndex;
    }
}
