package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBERS_OF_ELEMENTS = 10;
    private Pair[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_NUMBERS_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (getPair(key) != null) {
                pairs[i].setValue(value);
                return;
            }
        }
        Pair<K, V> pair = new Pair<>();
        pair.setKey(key);
        pair.setValue(value);
        pairs[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        Pair<K, V> node = getPair(key);
        return node != null ? node.getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> getPair(K key) {
        for (int i = 0; i < size; i++) {
            if (key == pairs[i].getKey()
                    || key != null && key.equals(pairs[i].getKey())) {
                return pairs[i];
            }
        }
        return null;
    }
}
