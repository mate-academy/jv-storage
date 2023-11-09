package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final ArrayList<K> kArray;
    private final ArrayList<V> vArray;

    public StorageImpl() {
        kArray = new ArrayList<>();
        vArray = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        if (kArray.contains(key)) {
            int index = kArray.indexOf(key);
            vArray.set(index, value);
        } else {
            kArray.add(key);
            vArray.add(value);
        }
    }

    @Override
    public V get(K key) {
        int index = kArray.indexOf(key);
        return (index != -1) ? vArray.get(index) : null;
    }

    @Override
    public int size() {
        if (kArray.size() == vArray.size()) {
            return kArray.size();
        } else {
            throw new RuntimeException("Size dont match");
        }
    }


}
