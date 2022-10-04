package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_AMOUNT = 10;
    private Pair<K,V> [] size = new Pair[MAX_STORAGE_AMOUNT];
    private boolean isReplaced = false;
    private int numberOfPairs = 0;

    @Override
    public void put(K key, V value) {
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
        } else {
            System.out.println("The storage is complete");
        }
        isReplaced = false;
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
