package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 100;
    private final List<K> keys;
    private final List<V> values;

    public StorageImpl() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if ((key == null && keys.get(i) == null) || (key != null && key.equals(keys.get(i)))) {
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
