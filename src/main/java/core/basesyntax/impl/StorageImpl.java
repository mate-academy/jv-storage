package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        int numberElement = keys.indexOf(key);
        if (numberElement == -1) {
            keys.add(key);
            values.add(value);
        } else {
            values.add(numberElement, value);
        }
    }

    @Override
    public V get(K key) {
        int numberElement = keys.indexOf(key);
        if (numberElement == -1) {
            return null;
        } else {
            return values.get(numberElement);
        }
    }

    @Override
    public int size() {
        return keys.size();
    }
}
