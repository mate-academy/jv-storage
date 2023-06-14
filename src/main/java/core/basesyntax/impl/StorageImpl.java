package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Map<K, V> storageMap;
    private int size;

    public StorageImpl() {
        this.storageMap = new HashMap<>();
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (storageMap.containsKey(null)) {
                storageMap.put(null, value);
            } else {
                if (size < MAX_SIZE) {
                    storageMap.put(null, value);
                    size++;
                } else {
                    throw new IllegalStateException("Storage is full");
                }
            }
        } else {
            if (storageMap.containsKey(key)) {
                storageMap.put(key, value);
            } else {
                if (size < MAX_SIZE) {
                    storageMap.put(key, value);
                    size++;
                } else {
                    throw new IllegalStateException("Storage is full");
                }
            }
        }
    }

    @Override
    public V get(K key) {
        return storageMap.get(key);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StorageImpl<?, ?> other = (StorageImpl<?, ?>) obj;
        return Objects.equals(storageMap, other.storageMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageMap);
    }
}

