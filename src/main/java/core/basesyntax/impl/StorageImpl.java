package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private ArrayList<K> keysArray = new ArrayList<>();
    private ArrayList<V> valuesArray = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        if (!keysArray.contains(key)) {
            keysArray.add(key);
            valuesArray.add(value);
        } else {
            valuesArray.set(keysArray.indexOf(key), value);
        }
    }

    @Override
    public V get(K key) {
        if (!keysArray.contains(key)) {
            return null;
        }
        return valuesArray.get(keysArray.indexOf(key));
    }

    @Override
    public int size() {
        return keysArray.size();
    }
}
