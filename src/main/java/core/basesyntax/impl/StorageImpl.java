package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private ArrayList<K> keyList = new ArrayList<>();
    private ArrayList<V> valueList = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        if (keyList.contains(key)) {
            valueList.set(keyList.indexOf(key),value);
        } else {
            keyList.add(key);
            valueList.add(value);
        }
    }

    @Override
    public V get(K key) {
        if (keyList.contains(key)) {
            return valueList.get(keyList.indexOf(key));
        } else {
            return null;
        }

    }

    @Override
    public int size() {
        return keyList.size();
    }
}
