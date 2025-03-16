package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;
import core.basesyntax.StorageIsCompleteException;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_AMOUNT = 10;
    private int numberOfPairs = 0;
    private Pair<K,V> [] size = new Pair[MAX_STORAGE_AMOUNT];

    @Override
    public void put(K key, V value) {
        boolean isReplaced = false;
        for (int i = 0; i < size(); i++) {
            if (size[i].getKey() == key || key != null && key.equals(size[i].getKey())) {
                Pair<K,V> pair = new Pair<>(key,value);
                size[i] = pair;
                isReplaced = true;
            }
        }
        if (numberOfPairs < MAX_STORAGE_AMOUNT && !isReplaced) {
            Pair<K,V> pair = new Pair<>(key, value);
            size[numberOfPairs++] = pair;
        } else if (numberOfPairs >= MAX_STORAGE_AMOUNT) {
            throw new StorageIsCompleteException("The storage is complete");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (size[i].getKey() == key || key != null && key.equals(size[i].getKey())) {
                return size[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfPairs;
    }
}
