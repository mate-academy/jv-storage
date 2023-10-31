package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int FIRST_ELEMENT = 0;
    private static final int STORAGE_LENGTH = 10;
    private final Pair<K, V>[] storage;
    private int index;

    public StorageImpl() {
        storage = new Pair[STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (storage[FIRST_ELEMENT] == null) {
            for (int i = 0; i < STORAGE_LENGTH; i++) {
                storage[i] = new Pair<>();
            }
        }
        for (int i = 0; i < index; i++) {
            if (equalKey(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
        storage[index].key = key;
        storage[index].value = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> element : storage) {
            if (equalKey(element.key, key)) {
                return element.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }

    public boolean equalKey(K firstKey, K secondKey) {
        return firstKey == null
                && secondKey == null
                || (firstKey != null
                && firstKey.equals(secondKey));
    }

    public static class Pair<K, V> {
        private K key;
        private V value;
    }
}
