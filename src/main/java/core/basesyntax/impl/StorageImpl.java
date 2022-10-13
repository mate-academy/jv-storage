package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final Pair[] pairs = new Pair[STORAGE_SIZE];
    private int size;


    public StorageImpl() {
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < pairs.length; i++) {
            if (key != null && pairs[i].getKey().equals(key) && !key.equals(0)) {
                Pair updateItem = pairs[i];
                updateItem.setValue(value);
                pairs[i] = updateItem;
                return;
            }
        }
        Pair pair = new Pair(key, value);
        pairs[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < pairs.length; i++) {
            if (key != null && pairs[i].getKey().equals(key)) {
                Pair value = pairs[i];
                return (V) value.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
