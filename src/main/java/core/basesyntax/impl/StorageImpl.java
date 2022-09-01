package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final List<K> listOfKeys = new ArrayList<>();
    private final List<V> listOfValues = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        if (listOfKeys.contains(key)) {
            listOfValues.set(listOfKeys.indexOf(key), value);
            return;
        }
        listOfKeys.add(key);
        listOfValues.add(value);
    }

    @Override
    public V get(K key) {
        if (!listOfKeys.contains(key)) {
            return null;
        }
        return listOfValues.get(listOfKeys.indexOf(key));
    }

    @Override
    public int size() {
        return listOfKeys.size();
    }
}
