package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {

    private List<Pair> storage = new ArrayList<>();
    @Override
    public void put(K key, V value) {
        final byte MAX_SIZE = 10;
        Pair pair = new Pair(key, value);
        if (pair.getValue() == null || storage.size() == MAX_SIZE) {
            return;
        }
        if (getIndex(key) >= 0) {
            int i = getIndex(key);
            storage.set(i, pair);
        } else {
            storage.add(pair);
        }
    }

    @Override
    public V get(K key) {
        for (Pair item : storage) {
            if (item.getKey() != null && item.getKey().equals(key)
                    || item.getKey() == key && key == null) {
                return (V) item.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storage.size();
    }

    private int getIndex(K key) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getKey() != null && storage.get(i).getKey().equals(key)
                    || storage.get(i).getKey() == null && key == null) {
                return i;
            }
        }
        return -1;
    }
}
