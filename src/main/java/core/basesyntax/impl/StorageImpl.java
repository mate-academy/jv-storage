package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final Object[] key;
    private final Object[] value;

    public StorageImpl() {
        value = new Object[ARRAY_SIZE];
        key = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if ((key != null && this.key[i] != null) && this.key[i].equals(key)) {
                this.value[i] = value;
                break;
            }
            if (this.key[i] == null && key == null) {
                this.value[i] = value;
                break;
            }
            if ((this.key[i] == null && this.value[i] == null) && key != null) {
                this.key[i] = key;
                this.value[i] = value;
                break;
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if ((key != null && this.key[i] != null) && this.key[i].equals(key)) {
                return (V) this.value[i];
            }
            if (this.key[i] == null && key == null) {
                return (V) this.value[i];
            }
            if ((this.key[i] == null && this.value[i] == null) && key != null) {
                return (V) value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (Object v : this.value) {
            if (v != null) {
                counter++;
            }
        }
        return counter;
    }
}
