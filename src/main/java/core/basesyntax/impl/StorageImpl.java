package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final byte STORAGE_VOLUME = 10;
    private final Pair<K, V>[] pairs = new Pair[STORAGE_VOLUME];
    private byte size;

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == pairs[i].getKey())
                    || (pairs[i].getKey() != null && pairs[i].getKey().equals(key))) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> currentItem : pairs) {
            if (currentItem != null
                    && (currentItem.getKey() == key
                    || currentItem.getKey() != null && currentItem.getKey().equals(key))) {
                return currentItem.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
