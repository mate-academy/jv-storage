package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final ArrayList<K> listK = new ArrayList<>();
    private final ArrayList<V> listV = new ArrayList<>();
    private int storageSpace = 10;

    @Override
    public void put(K key, V value) {
        if (storageSpace > 0) {
            if (!listK.contains(key)) {
                listK.add(key);
                listV.add(value);
                storageSpace--;
            } else if (listK.contains(key)) {
                int index = listK.indexOf(key);
                listV.set(index, value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = listK.indexOf(key);
        if (index == (-1)) {
            return null;
        }
        return listV.get(index);
    }

    @Override
    public int size() {
        return listK.size();
    }
}
