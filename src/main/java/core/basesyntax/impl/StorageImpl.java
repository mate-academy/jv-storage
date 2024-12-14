package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final List<K> keys;
    private final List<V> values;

    public StorageImpl() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.size(); i++) {
            if (Objects.equals(keys.get(i), key)) {
                values.set(i, value);
                return;
            }
        }

        keys.add(key);
        values.add(value);
    }

    @Override
    public V get(K key) {
        int keyPosition = this.keys.indexOf(key);
        if (keyPosition == -1) {
            return null;
        }
        return this.values.get(keyPosition);
    }

    @Override
    public int size() {
        return this.keys.size();
    }
}
