package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_INDEX = 10;
    private int size;
    private final Object[] key;
    private final Object[] value;

    public StorageImpl() {
        key = new Object[MAX_ARRAY_INDEX];
        value = new Object[MAX_ARRAY_INDEX];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((this.key[i] == null && key == null)
                    || (this.key[i] != null && this.key[i].equals(key))) {
                this.value[i] = value;
                return;
            }
        }
        this.key[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((this.key[i] == null && key == null)
                    || (this.key[i] != null && this.key[i].equals(key))) {
                return (V) this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
