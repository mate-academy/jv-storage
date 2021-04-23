package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Pair<K, V>[] storage;

    public StorageImpl() {
        storage = new Pair[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = Pair.of(key, value);
                break;
            }
            if (storage[i].getFirst() != null && storage[i].getFirst().equals(key)) {
                storage[i] = Pair.of(key, value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> shelf : storage) {
            if (shelf != null
                    && (key == null && shelf.getFirst() == null
                        || shelf.getFirst() != null && shelf.getFirst().equals(key))) {
                return shelf.getSecond();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
