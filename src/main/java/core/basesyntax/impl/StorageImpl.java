package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] temp;
    private int size;

    public StorageImpl() {
        temp = new Pair[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (Pair<K, V> item : temp) {
            if (item != null && ((item.getKey() == null && key == null) && item.getValue() != null
                    || (item.getKey() != null && item.getKey().equals(key)))) {
                item.setValue(value);
                return;
            }
        }
        temp[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> item : temp) {
            if (item != null && ((item.getKey() == null && key == null) && item.getValue() != null
                    || (item.getKey() != null && item.getKey().equals(key)))) {
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
