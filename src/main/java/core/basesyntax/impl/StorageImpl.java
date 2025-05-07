package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V> [] pairs = new Pair[10];
    private int lastFreeIndex = 0;
    private Pair<?, V> nullPair;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (nullPair == null) {
                nullPair = new Pair<>(null, value);
            } else {
                nullPair.setValue(value);
            }
        } else if (contains(key)) {
            getPair(key).setValue(value);
        } else {
            if (lastFreeIndex == pairs.length - 2) {
                pairs = Arrays.copyOf(pairs, pairs.length * 2);
            }
            pairs[lastFreeIndex] = new Pair(key, value);
            lastFreeIndex++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return nullPair.getValue();
        } else {
            for (int i = 0; i < lastFreeIndex; i++) {
                if (pairs[i].getKey().equals(key)) {
                    return pairs[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return nullPair != null ? lastFreeIndex + 1 : lastFreeIndex;
    }

    private boolean contains(K key) {
        if (key == null) {
            if (nullPair != null) {
                return true;
            }
        } else {
            for (int i = 0; i < lastFreeIndex; i++) {
                if (pairs[i].getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Pair<K, V> getPair(K key) {
        if (key == null) {
            return nullPair != null ? (Pair<K, V>) nullPair : null;
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
