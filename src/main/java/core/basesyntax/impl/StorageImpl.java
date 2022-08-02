package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final ArrayList<V> valueArrays;
    private final ArrayList<K> keyArrays;

    public StorageImpl() {
        valueArrays = new ArrayList<>();
        keyArrays = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        if (valueArrays.size() == 0 || !keyArrays.contains(key)) {
            valueArrays.add(value);
            keyArrays.add(key);
        } else {
            int index = keyArrays.indexOf(key);
            valueArrays.set(index, value);
        }
    }

    @Override
    public V get(K key) {
        if (keyArrays.contains(key)) {
            return valueArrays.get(keyArrays.indexOf(key));
        }
        return null;
    }

    @Override
    public int size() {
        return valueArrays.size();
    }
}
