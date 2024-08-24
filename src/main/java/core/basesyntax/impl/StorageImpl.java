package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private ArrayList<K> keys = new ArrayList<>(10);
    private ArrayList<V> values = new ArrayList<>(10);

    @Override
    public void put(K key, V value) {
        boolean checker = false;
        for (int i = 0; i < keys.size(); i++) {
            if (key == null ? keys.get(i) == null : key.equals(keys.get(i))) {
                values.set(i, value);
                checker = true;
                break;
            }
        }
        if (!checker) {
            if (keys.size() < 10) {
                keys.add(key);
                values.add(value);
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key == null ? keys.get(i) == null : key.equals(keys.get(i))) {
                return values.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
