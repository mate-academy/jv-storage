package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private ArrayList<K> keyList;
    private ArrayList<V> valueList;

    public StorageImpl() {
        keyList = new ArrayList<>(MAX_CAPACITY);
        valueList = new ArrayList<>(MAX_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            valueList.set(index, value);
        } else {
            if (keyList.size() < MAX_CAPACITY) {
                keyList.add(key);
                valueList.add(value);
            } else {
                throw new IllegalStateException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return (index != -1) ? valueList.get(index) : null;
    }

    @Override
    public int size() {
        return keyList.size();
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < keyList.size(); i++) {
            if ((keyList.get(i) == null && key == null)
                    || (keyList.get(i) != null && keyList.get(i).equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
