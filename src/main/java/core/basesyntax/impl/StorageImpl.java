package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    ArrayList<K> keys = new ArrayList<K>();
    ArrayList<V> data = new ArrayList<V>();

    @Override
    public void put(K key, V value) {
        for(int i = 0; i < keys.size(); i++) {
            if(keys.get(i).equals(key)) {
                data.set(i, value);
                return;
            }
        }
        keys.add(key);
        data.add(value);
    }

    @Override
    public V get(K key) {
        for(int i = 0; i < keys.size(); i++) {
            if(keys.get(i).equals(key)) {
                return data.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
