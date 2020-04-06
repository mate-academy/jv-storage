package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {

    List<K> listKay = new ArrayList<K>();
    List<V> listValue = new ArrayList<V>();

    @Override
    public void put(K key, V value) {
        if (listKay.contains(key)) {
            listValue.add(listKay.indexOf(key), value);
        } else {
            listKay.add(key);
            listValue.add(value);
        }
    }

    @Override
    public V get(K key) {
        return listKay.contains(key) ? listValue.get(listKay.indexOf(key)) : null;
    }
}
