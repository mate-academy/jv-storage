package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private int size;
    private Pair[] pairs;

    public StorageImpl() {
        pairs = new Pair[MAX_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == pairs[i].getKey() || key != null && key.equals(pairs[i].getKey())) {
                pairs[i].setValue(value);
                return;
            }
        }
        //create the Pair with key and value
        Pair<K, V> pair = new Pair<>();
        pair.setKey(key);
        pair.setValue(value);
        pairs[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        Pair<K, V> getK = getPair(key);
        return getK != null ? getK.getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> getPair(K key) {
        for (int i = 0; i < size; i++) {
            if (key == pairs[i].getKey() || key != null && key.equals(pairs[i].getKey())) {
                return pairs[i];
            }
        }
        return null;
    }
}
