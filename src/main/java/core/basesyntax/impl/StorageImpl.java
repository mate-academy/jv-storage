package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final int INDEX_IS_NOT_PRESENT = -1;
    private Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOfEqualKeys(key);
        if (index != INDEX_IS_NOT_PRESENT) {
            pairs[index].value = value;
            return;
        }
        if (size < MAX_ARRAY_SIZE) {
            pairs[size] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexOfEqualKeys(key);
        if (index != INDEX_IS_NOT_PRESENT) {
            return pairs[index].value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOfEqualKeys(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == pairs[i].key) || (key != null && key.equals(pairs[i].key))) {
                return i;
            }
        }
        return INDEX_IS_NOT_PRESENT;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
