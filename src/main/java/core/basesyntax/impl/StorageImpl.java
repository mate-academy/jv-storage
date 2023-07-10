package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_VALUE = 10;
    private KeyValuePair<K, V>[] keyValuePairs;

    public StorageImpl() {
        keyValuePairs = new KeyValuePair[MAX_ITEMS_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_VALUE; i++) {
            KeyValuePair target = keyValuePairs[i];
            if (target == null) {
                keyValuePairs[i] = new KeyValuePair(key, value);
                return;
            } else if (target.equalsByKey(key)) {
                target.setValue(value);
                return;
            }
        }
        throw new IndexOutOfBoundsException("storedItems is already full");
    }

    @Override
    public V get(K key) {
        for (KeyValuePair keyValuePair : keyValuePairs) {
            if (keyValuePair != null && keyValuePair.equalsByKey(key)) {
                return (V) keyValuePair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int sizeValue = 0;
        for (KeyValuePair keyValuePair : keyValuePairs) {
            if (keyValuePair == null) {
                break;
            }
            sizeValue++;
        }
        return sizeValue;
    }
}
