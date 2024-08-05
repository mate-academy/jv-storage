package core.basesyntax;

import core.basesyntax.impl.StorageFullException;

public interface Storage<K, V> {
    void put(K key, V value) throws StorageFullException;

    V get(K key);

    int size();
}
