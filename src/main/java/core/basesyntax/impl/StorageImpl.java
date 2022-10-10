package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private List<K> keys = new ArrayList();
    private List<V> values = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        if (!keys.contains(key)) {
            this.key = key;
            this.value = value;
            keys.add(key);
            values.add(value);
        } else {
            int indexOfValueToBeRewritten = values.indexOf(keys.indexOf(key));
            values.add(indexOfValueToBeRewritten + 1, value);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(keys.get(0) + ", " + values.get(0));
        for (int i = 1; i < keys.size(); i++) {
            stringBuilder.append("\n").append(keys.get(i) + ", " + values.get(i));
        }
        return stringBuilder.toString();
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        } else {
            return values.get(keys.indexOf(key));
        }
    }

    @Override
    public int size() {
        return keys.size();
    }
}
