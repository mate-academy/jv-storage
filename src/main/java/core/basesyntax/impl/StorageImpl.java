package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final ArrayList<V> valuesList = new ArrayList<>();
    private final ArrayList<K> keysList = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        if (keysList.contains(key)) {
            valuesList.set(keysList.indexOf(key), value);
            return;
        }
        valuesList.add(value);
        keysList.add(key);
    }

    @Override
    public V get(K key) {
        return keysList.contains(key) ? valuesList.get(keysList.indexOf(key)) : null;
    }

    @Override
    public int size() {
        return valuesList.size();
    }
}
