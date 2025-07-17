package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int usedStorage = 0;
    private Pair<K, V>[] pairs = new Pair[MAX_ARRAY_SIZE];

    private static class Pair<K, V> {
        private K key;
        private V value;
    }

    public StorageImpl() {
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            pairs[i] = new Pair<>();
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < usedStorage; i++) {
            if (key == null && pairs[i].key == null) {
                pairs[i].value = value;
                return;
            }
            if (key != null && key.equals(pairs[i].key)) {
                pairs[i].value = value;
                return;
            }
        }

        if (usedStorage >= MAX_ARRAY_SIZE) {
            throw new RuntimeException("Can't add new pair. Storage is full");
        }

        pairs[usedStorage].key = key;
        pairs[usedStorage].value = value;
        usedStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < usedStorage; i++) {
            if (key == null && pairs[i].key == null) {
                return pairs[i].value;
            }
            if (key != null && key.equals(pairs[i].key)) {
                return pairs[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return usedStorage;
    }
}
