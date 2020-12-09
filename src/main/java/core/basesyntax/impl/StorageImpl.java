package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_ARRAY = 10;
    private int counter;
    private Object[] key;
    private Object[] value;

    public StorageImpl() {
        this.counter = 0;
        this.key = new Object[LENGTH_ARRAY];
        this.value = new Object[LENGTH_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (this.key[i] == key || key != null && key.equals(this.key[i])) {
                this.value[i] = value;
                break;
            }
        }
        this.key[counter] = key;
        this.value[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (this.key[i] == key || key != null && key.equals(this.key[i])) {
                return (V) this.value[i];
            }
        }
        return null;
    }
}
