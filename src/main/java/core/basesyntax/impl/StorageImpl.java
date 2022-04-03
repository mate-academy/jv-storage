package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StorageImpl<K, V> implements Storage<K, V> {
    private List<K> keyResult = new ArrayList<>();
    private List<V> valueResult = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        valueResult.add(value);
        keyResult.add(key);
        for (int i = 0; i < keyResult.size(); i++) {
            if (key == keyResult.get(i) || key != null && key.equals(keyResult.get(i))) {
                valueResult.set(i, value);
            }
        }
        Set<V> set = new LinkedHashSet<>(valueResult);
        valueResult.clear();
        valueResult.addAll(set);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyResult.size(); i++) {
            if (key == keyResult.get(i) || key != null && key.equals(keyResult.get(i))) {
                return valueResult.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return valueResult.size();
    }
}
