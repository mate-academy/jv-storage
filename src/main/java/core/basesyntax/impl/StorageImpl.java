package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.LinkedList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final List<K> keysList = new LinkedList<>();
    private final List<V> valuesList = new LinkedList<>();

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keysList.add(key);
            valuesList.add(value);
        } else {
            int indexOfKey = keysList.indexOf(key);
            valuesList.set(indexOfKey, value);
        }
    }

    @Override
    public V get(K key) {
        int indexOfKey = keysList.indexOf(key);
        if (indexOfKey == -1) {
            return null;
        }
        return valuesList.get(indexOfKey);
    }

    @Override
    public int size() {
        return keysList.size();
    }
}
