package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private List<K> keyList = new ArrayList<>();
    private List<V> valueList = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        if (keyList.contains(key)) {
            valueList.add(keyList.indexOf(key), value);
        } else {
            keyList.add(key);
            valueList.add(value);
        }
    }

    @Override
    public V get(K key) {
        return keyList.contains(key) ? valueList.get(keyList.indexOf(key)) : null;
    }

}
