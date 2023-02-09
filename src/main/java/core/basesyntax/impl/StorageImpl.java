package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_QUANTITY = 10;
    private int size;
    private Pair[] storage;

    public StorageImpl() {
        storage = new Pair[MAX_ITEMS_QUANTITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areEqual(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
        storage[size++] = new Pair(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areEqual(storage[i].key, key)) {
                return (V) storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areEqual(Object o1, Object o2) {
        return o1 == o2 || o1 != null && o1.equals(o2);
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
