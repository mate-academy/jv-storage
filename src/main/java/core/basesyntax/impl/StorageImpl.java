package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] pairsArray;
    private int size;

    public StorageImpl() {
        pairsArray = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && pairsArray[i].key == null) {
                pairsArray[i].value = value;
                return;
            }
            if (pairsArray[i].key == null) {
                break;
            }
            if (pairsArray[i].key.equals(key)) {
                pairsArray[i].value = value;
                return;
            }
        }
        this.pairsArray[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && pairsArray[i].key == null) {
                return pairsArray[i].value;
            }
            if (pairsArray[i].key == null) {
                i++;
            }
            if (pairsArray[i].key.equals(key)) {
                return pairsArray[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {

        private final K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
