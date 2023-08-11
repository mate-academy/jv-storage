package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private final Pair[] pairs;
    private int index;

    public StorageImpl() {
        pairs = new Pair[STORAGE_CAPACITY];
        index = -1;
    }

    @Override
    public void put(K key, V value) {
        if (canBeAdded()) {
            int keyIndex = getKeyIndex(key);
            if (keyIndex >= 0) {
                pairs[keyIndex].setValue(value);
            } else {
                pairs[++index] = new Pair<>(key, value);
            }
        }
    }

    @Override
    public V get(K key) {
        return getKeyIndex(key) >= 0 ? (V) pairs[getKeyIndex(key)].getValue() :
                null;
    }

    @Override
    public int size() {
        return index + 1;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i <= index; i++) {
            if ((pairs[i].getKey() != null && pairs[i].getKey().equals(key))
                    || (pairs[i].getKey() == null && key == null)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canBeAdded() {
        return size() < STORAGE_CAPACITY;
    }
}
