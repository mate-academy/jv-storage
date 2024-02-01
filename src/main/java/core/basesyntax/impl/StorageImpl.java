package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Pair<K, V>[] keyValuePairs;
    private int keyValuePairsSize;

    public StorageImpl() {
        keyValuePairs = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> current = new Pair<>(key, value);
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (keyValuePairs[i] == null) {
                keyValuePairs[i] = current;
                keyValuePairsSize++;
                return;
            }

            if ((current.getKey() == keyValuePairs[i].getKey())
                    || ((current.getKey() != null)
                    && current.getKey().equals(keyValuePairs[i].getKey()))) {
                keyValuePairs[i].setValue(current.getValue());
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> keyValuePair : keyValuePairs) {
            if (keyValuePair == null) {
                return null;
            }

            if ((keyValuePair.getKey() == key)
                    || ((keyValuePair.getKey() != null)
                    && keyValuePair.getKey().equals(key))) {
                return keyValuePair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyValuePairsSize;
    }
}
