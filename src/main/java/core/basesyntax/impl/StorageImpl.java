package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int pointer;

    public StorageImpl() {
        this.values = (V[]) new Object[ARRAY_SIZE];
        this.keys = (K[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int pos;
        for (int i = 0; i < keys.length; i++) {
            if (pointer != 0 && (pos = getKeyPos(key)) >= 0) {
                putPairOnPosition(key,value,pos);
            } else {
                putPairOnPosition(key, value, pointer);
                pointer++;
            }
        }
    }

    public void putPairOnPosition(K key, V value, int pos) {
        keys[pos] = key;
        values[pos] = value;
    }

    private int getKeyPos(K key) {
        for (int i = 0; i < pointer; i++) {
            if (isEquals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEquals(K key, K key1) {
        return Objects.equals(key, key1);
    }

    @Override
    public V get(K key) {
        int pos;
        if (pointer > 0 && (pos = getKeyPos(key)) >= 0) {
            return values[pos];
        }
        return null;
    }

    @Override
    public int size() {
        return pointer;
    }
}
