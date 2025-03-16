package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Pair;
import java.lang.reflect.Array;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int INITIAL_STORAGE_SIZE = 0;
    private int size;
    private Pair<K, V>[] pairs;

    public StorageImpl() {
        pairs = (Pair<K,V>[]) Array.newInstance(Pair.class, MAX_ITEMS_NUMBER);
        size = INITIAL_STORAGE_SIZE;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < pairs.length; i++) {
            if (isExistKey(pairs[i], key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        addNewPair(new Pair<>(key, value));
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (isExistKey(pair, key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isExistKey(Pair<K, V> pair, K key) {
        return pair != null && Objects.equals(pair.getKey(), key);
    }

    private void addNewPair(Pair<K, V> pair) {
        checkFreeSpaceInPairs();
        pairs[size++] = pair;
    }

    private void checkFreeSpaceInPairs() {
        if (size() == pairs.length - 1) {
            throw new RuntimeException("Storage is full");
        }
    }

}
