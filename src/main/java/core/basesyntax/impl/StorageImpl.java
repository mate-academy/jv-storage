package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.ArrayList;


public class StorageImpl<K, V> implements Storage<K, V> {
    ArrayList<K> kArray = new ArrayList<>();
    ArrayList<V> vArray = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        if (!kArray.contains(key)) {
            kArray.add(key);
            vArray.add(value);
        } else {
            vArray.set(kArray.indexOf(key), value);
        }
    }

    @Override
    public V get(K key) {
        if (!kArray.contains(key)) {
            return null;
        }
        return vArray.get(kArray.indexOf(key));
    }

    @Override
    public int size() {
        return kArray.size();
    }
}
