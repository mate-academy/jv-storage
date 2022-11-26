package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_SIZE = 10;
    private Cell<K, V>[] storage;
    private int count;

    private class Cell<K, V> {
        private K key;
        private V value;

        private Cell(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public StorageImpl() {
        this.storage = new Cell[MAX_SIZE];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (storage[i] == null) {
                storage[i] = new Cell(key, value);
                count++;
                return;
            }
            if (Objects.equals(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (storage[i] != null && Objects.equals(storage[i].key, key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
