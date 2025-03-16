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
        KeyValuePair pair = new KeyValuePair(key, value);
        for (int i = 0; i < MAX_ITEMS_VALUE; i++) {
            KeyValuePair target = keyValuePairs[i];
            if (target == null) {
                keyValuePairs[i] = pair;
                return;
            } else if (target.equals(pair)) {
                target.setValue(value);
                return;
            }
        }
        throw new IndexOutOfBoundsException("storedItems is already full");
    }

    @Override
    public V get(K key) {
        KeyValuePair pair = new KeyValuePair(key);
        for (KeyValuePair keyValuePair : keyValuePairs) {
            if (keyValuePair != null && keyValuePair.equals(pair)) {
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
