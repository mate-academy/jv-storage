package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final List<V> nullValues = new ArrayList<>();
    private final List<Pair<K, V>> list = new ArrayList<>();

    @Override
    public void put(K key, V value) {

        if (key == null) {
            if (nullValues.isEmpty()) {
                nullValues.add(value);
            } else {
                nullValues.set(0, value);
            }
        } else {
            Pair<K,V> existingPair = null;
            for (Pair<K,V> pair : list) {
                if (key.equals(pair.key)) {
                    existingPair = pair;
                    break;
                }
            }
            if (existingPair == null || existingPair.key == null) {
                list.add(new Pair<>(key, value));
            } else {
                existingPair.value = value;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            if (nullValues.isEmpty()) {
                return null;
            } else {
                return nullValues.get(0);
            }
        } else {
            for (Pair<K, V> pair : list) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = list.size();
        if (!nullValues.isEmpty()) {
            size++;
        }
        return size;
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
