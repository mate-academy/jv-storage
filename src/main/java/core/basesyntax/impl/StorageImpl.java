package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int PAIRS_MAX_LEN = 10;

    private final List<K> keys;
    private final List<V> values;
    private int size;

    public StorageImpl() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = this.getPairIndexByKey(key);

        if (keyIndex == -1) {
            addPair(key, value);
        } else {
            changeValue(keyIndex, value);
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = this.getPairIndexByKey(key);

        if (keyIndex == -1) {
            return null;
        }

        return this.values.get(keyIndex);
    }

    @Override
    public int size() {
        return size;
    }

    private int getPairIndexByKey(K key) {
        for (int i = 0; i < this.size; i++) {
            K currentKey = this.keys.get(i);

            if (key == null ? currentKey == key : key.equals(currentKey)) {
                return i;
            }
        }

        return -1;
    }

    private void addPair(K key, V value) {
        int len = this.size();

        if (len == PAIRS_MAX_LEN) {
            throw new RuntimeException("You cannot add new pair! An array is full.");
        }

        this.keys.add(key);
        this.values.add(value);
        this.size++;
    }

    private void changeValue(int index, V value) {
        this.values.set(index, value);
    }
}
