package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final ArrayList<K> keys = new ArrayList<>();
    private final ArrayList<V> values = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == -1) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keyIndex, value);
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == -1) {
            return null;
        }
        return values.get(indexOfKey(key));
    }

    @Override
    public int size() {
        return keys.size();
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key == keys.get(i) || key != null && key.equals(keys.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
