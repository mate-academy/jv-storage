package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private int nextIndex = 0;
    private int indexKey;
    private final KeyValuePair<K, V>[] pairsArray = new KeyValuePair[MAX_ITEMS];

    private boolean findKeyIndex(KeyValuePair<K, V> pair) {
        for (int i = 0; i < pairsArray.length; i++) {
            if (pairsArray[i] != null && pairsArray[i].getKey() == null) {
                indexKey = i;
                return pairsArray[i].getKey() == pair.getKey();
            }
            if (pairsArray[i] != null && pairsArray[i].getKey().equals(pair.getKey())) {
                indexKey = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        KeyValuePair<K, V> newPair = new KeyValuePair<>(key, value);
        if (findKeyIndex(newPair)) {
            pairsArray[indexKey].setValue(newPair.getValue());
        } else {
            pairsArray[nextIndex] = newPair;
            nextIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (KeyValuePair<K, V> box: pairsArray) {
            if (box != null) {
                if (box.getKey() == null && key == null) {
                    return box.getValue();
                } else if (box.getKey() != null && box.getKey().equals(key)) {
                    return box.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int lengthCounter = 0;
        for (KeyValuePair<K, V> box: pairsArray) {
            if (box != null) {
                lengthCounter++;
            }
        }
        return lengthCounter;
    }
}
