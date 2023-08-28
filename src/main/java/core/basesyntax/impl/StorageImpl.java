package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_LENGTH = 10;
    private final Pair<K, V>[] pairs;
    private int index;

    public StorageImpl() {
        pairs = new Pair[STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex >= 0) {
            pairs[keyIndex].setValue(value);
        } else {
            if (isFull()) {
                return;
            }
            pairs[index++] = new Pair<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return keyIndex >= 0 ? pairs[keyIndex].getValue() :
                null;
    }

    @Override
    public int size() {
        return index;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size(); i++) {
            K current = pairs[i].getKey();
            if (current == key || current != null && current.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isFull() {
        return size() >= STORAGE_LENGTH;
    }
}
