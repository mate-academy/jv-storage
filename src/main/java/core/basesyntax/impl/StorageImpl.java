package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final ArrayList<K> keys;
    private final ArrayList<V> values;

    public StorageImpl() {
        keys = new ArrayList<>(10);
        values = new ArrayList<>(10);
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);

        if (keyIndex != -1) {
            values.set(keyIndex, value);
        } else {
            keys.add(key);
            values.add(value);
        }

    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);

        if (keyIndex != -1) {
            return values.get(keyIndex);
        }
        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if ((key == null && keys.get(i) == null)
                        || (keys.get(i) != null && keys.get(i).equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
