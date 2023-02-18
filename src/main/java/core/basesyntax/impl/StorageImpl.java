package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    List<K> keyList = new ArrayList<>();
    List<V> valueList = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyList.size(); i++) {
            if (key == null && keyList.get(i) == null) {
                valueList.set(i, value);
                return;
            }
            if (keyList.get(i) != null && keyList.get(i).equals(key)) {
                valueList.set(i, value);
                return;
            }
        }
        addCell(key, value);
    }

    private void addCell(K key, V value) {
        keyList.add(key);
        valueList.add(value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyList.size(); i++) {
            if (key == null && keyList.get(i) == null) {
                return valueList.get(i);
            }
            if (keyList.get(i) != null && keyList.get(i).equals(key)) {
                return valueList.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyList.size();
    }
}
