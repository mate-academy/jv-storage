package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private StorageImpl[] storages = new StorageImpl[10];

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    @Override
    public void put(K key, V value) {
        for (StorageImpl<K, V> str : storages) {
            if (str != null && Objects.equals(str.getKey(), key)) {
                str.value = value;
                return;
            }
        }
        for (int i = 0; i < storages.length; i++) {
            if (storages[i] == null) {
                storages[i] = new StorageImpl<K, V>();
                storages[i].setKey(key);
                storages[i].setValue(value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> str : storages) {
            if (str != null && Objects.equals(str.key, key)) {
                return str.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (StorageImpl<K, V> str : storages) {
            if (str != null) {
                size++;
            }
        }
        return size;
    }
}
