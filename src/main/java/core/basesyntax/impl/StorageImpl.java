package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    @SuppressWarnings("FieldMayBeFinal")
    private Pair<K, V>[] pairs;
    private int actualSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        pairs = new Pair[MAX_SIZE];
        actualSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if (key == pairs[i].getKey()
                    || pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[actualSize++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == pairs[i].getKey()
                    || pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return actualSize;
    }
}
