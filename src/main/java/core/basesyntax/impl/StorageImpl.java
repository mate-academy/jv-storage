package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V> [] pairs = new Pair[10];
    private int lastFreeIndex = 1;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            pairs[0] = new Pair<>(key, value);
        } else if (contains(key)) {
            getPair(key).setValue(value);
        } else {
            pairs[lastFreeIndex] = new Pair(key, value);
            lastFreeIndex++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return pairs[0] == null ? null : pairs[0].getValue();
        } else {
            for (int i = 1; i < lastFreeIndex; i++) {
                if (pairs[i].getKey().equals(key)) {
                    return pairs[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return pairs[0] == null ? lastFreeIndex - 1 : lastFreeIndex;
    }

    private boolean contains(K key) {
        for (int i = 1; i < lastFreeIndex; i++) {
            if (pairs[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    private Pair<K, V> getPair(K key) {
        if (key == null) {
            return pairs[0] == null ? null : pairs[0];
        } else {
            for (int i = 1; i < lastFreeIndex; i++) {
                if (pairs[i].getKey().equals(key)) {
                    return pairs[i];
                }
            }
            return null;
        }
    }
}
