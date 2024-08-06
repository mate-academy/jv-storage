package core.basesyntax;

import core.basesyntax.impl.FullStorageException;

public interface Storage<K, V> {
    void put(K key, V value) throws FullStorageException;

    V get(K key);

    int size();
}
