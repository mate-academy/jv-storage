package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private int nextIndex;
    private int indexKey;
    private int sizeOfStorage;
    private KeyValuePair<K, V>[] pairsArray;

    public StorageImpl() {
        this.nextIndex = 0;
        this.indexKey = 0;
        this.sizeOfStorage = 0;
        this.pairsArray = new KeyValuePair[MAX_ITEMS];
    }

    @Override
    public void put(K key, V value) {
        KeyValuePair<K, V> newPair = new KeyValuePair<>(key, value);
        if (findKeyIndex(newPair)) {
            pairsArray[indexKey].setValue(newPair.getValue());
        } else {
            pairsArray[nextIndex] = newPair;
            nextIndex++;
            sizeOfStorage++;
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
        return sizeOfStorage;
    }

    private boolean findKeyIndex(KeyValuePair<K, V> pair) {
        for (int i = 0; i < pairsArray.length; i++) {
            if (pairsArray[i] != null) {
                if (pairsArray[i].getKey() == null && pairsArray[i].getKey() == pair.getKey()) {
                    indexKey = i;
                    return true;
                } else if (pairsArray[i].getKey() != null && pair.getKey() != null
                        && pairsArray[i].getKey().equals(pair.getKey())) {
                    indexKey = i;
                    return true;
                }
            }
        }
        return false;
    }
}


