package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DATA_CAPACITY = 10;
    private final Pair<K, V>[] data;
    private int elementsCount;

    public StorageImpl() {
        this.data = new Pair[DATA_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = contains(key);
        if (index != -1) {
            data[index].value = value;
            return;
        }
        data[elementsCount++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        int index = contains(key);
        return index > -1 ? data[index].value : null;
    }

    @Override
    public int size() {
        return elementsCount;
    }

    private int contains(K key) {
        int index = 0;
        for (Pair<K, V> pair : data) {
            if (pair == null) {
                return -1;
            }
            if (key == pair.key || pair.key != null && pair.key.equals(key)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
